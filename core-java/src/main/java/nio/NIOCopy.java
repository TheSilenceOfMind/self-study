package nio;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println("Usage: Copy from to");
            return;
        }

        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (InvalidPathException e) {
            System.err.println("Path error " + e);
        } catch (IOException e) {
            System.err.println("I/O error " + e);
        }
    }
}
