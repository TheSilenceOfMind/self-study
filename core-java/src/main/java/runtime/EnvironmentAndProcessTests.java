package runtime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class EnvironmentAndProcessTests {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() +
                        ": " + "Just before the VM termination I was called!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "my thread hook");

        runtime.addShutdownHook(t);

        Process p = runtime.exec("notepad.exe");
        System.out.println(Thread.currentThread().getName() +
                ": " + "VM had " + runtime.freeMemory() / 1024 / 1024 + " MiB of free memory");
        try {
            p.waitFor(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() +
                    ": " + "interrupted from notepad!");
        }

        System.out.println(Thread.currentThread().getName() +
                ": " + "notepad returned with code " + p.exitValue());
    }
}
