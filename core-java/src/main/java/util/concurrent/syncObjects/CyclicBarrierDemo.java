package util.concurrent.syncObjects;

import java.util.concurrent.*;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Done! Barrier reached!"));

        for (int i = 0; i < 10; i++) {
            String a = String.valueOf((char)('A' + i));
            new MyThreadCB(cb, a);
        }

    }
}

class MyThreadCB implements Runnable {
    CyclicBarrier cb;
    String name;
    static int timer = 0;

    public MyThreadCB(CyclicBarrier cb, String name) {
        this.cb = cb;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timer = timer + 1000);
            System.out.println("Start " + name);
            for (int i = 0; i < 3; i++) {
                System.out.println(name + " " + i);
                Thread.sleep(300);
            }
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println(e);
        }

    }
}
