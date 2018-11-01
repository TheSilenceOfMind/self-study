package nio.channel;

import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.nio.file.*;

public class MappedChannelRead {

    private static final String FILEPATH_STRING = "src/main/java/nio/channel/test.txt";

    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Paths.get(FILEPATH_STRING))) {
            long fSize = fileChannel.size();
            MappedByteBuffer mBuf = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
            for (int i = 0; i < fSize; i++)
                System.out.print((char)mBuf.get(i));
            System.out.println();

        } catch (IOException e) {
            System.err.println("I/O error " + e);
        } catch (InvalidPathException e) {
            System.err.println("path exception " + e);
        }
    }
}
