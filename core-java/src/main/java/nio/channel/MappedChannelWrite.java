package nio.channel;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

import static java.nio.file.StandardOpenOption.*;

public class MappedChannelWrite {

    private static final String FILEPATH_STRING = "src/main/java/nio/channel/test.txt";

    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                Paths.get(FILEPATH_STRING), WRITE, READ, CREATE)) {

            MappedByteBuffer buf = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++)
                buf.put((byte)('A' + i));

        } catch (IOException e) {
            System.err.println("I/O error " + e);
        } catch (InvalidPathException e) {
            System.err.println("path exception " + e);
        }
    }
}
