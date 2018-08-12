package runtime;

import java.io.IOException;

public class ProcessBuilderTest {

    public static void main(String... args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe", "testfile");
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
