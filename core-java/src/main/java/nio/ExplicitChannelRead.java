package nio;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;

        try ( SeekableByteChannel fChannel = Files.newByteChannel(Paths.get("src/main/java/nio/test.txt"))) {
            ByteBuffer mBuf = ByteBuffer.allocate(128);
            do {
                count = fChannel.read(mBuf);
                if (count != -1) {
                    mBuf.rewind(); // reset position of the pointer to the 0 index
                    for (int i = 0; i < count; i++)
                        System.out.print((char)mBuf.get(i));
                }
            } while (count != -1);

            System.out.println();
        } catch (IOException e) {
            System.err.println("I/O error " + e);
        } catch (InvalidPathException e) {
            System.err.println("path exception " + e);
        }
    }
}
