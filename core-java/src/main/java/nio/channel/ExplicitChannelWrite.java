package nio.channel;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelWrite {

    private static final String FILEPATH_STRING = "src/main/java/nio/channel/test.txt";

    public static void main(String[] args) {

        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get(FILEPATH_STRING),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE)) {

            ByteBuffer buf = ByteBuffer.allocate(26);
            for (int i = 0; i < 26; i++)
                buf.put((byte) ('A' + i));
            buf.rewind();
            fileChannel.write(buf);
            System.out.println("before rewind(): current pointer position in buffer: " + buf.position());
            buf.rewind();
            System.out.println("after rewind(): current pointer position in buffer: " + buf.position());

        } catch (IOException e) {
            System.err.println("I/O error " + e);
        } catch (InvalidPathException e) {
            System.err.println("path exception " + e);
        }
    }
}
