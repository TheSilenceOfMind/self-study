package nio;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DirList {

    private static final String dirname = "src/main/java/nio/";

    public static void main(String[] args) {

        DirectoryStream.Filter<Path> how = Files::isWritable;

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {

            System.out.println("Directory of " + dirname);
            int levelOfTheDirEntryInPath = getLevelNum(dirname);
            for (Path entry : dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else
                    System.out.print("      ");
                System.out.println(entry.getName(levelOfTheDirEntryInPath));
            }
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
        } catch (NotDirectoryException e) {
            System.out.println(dirname + " is not a directory.");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }


    private static int getLevelNum(String dirname) {
        char[] c = dirname.toCharArray();
        int count = 0;
        int ind = c.length - 1;

        while (c[ind--] == '/' || c[ind] == '\\') ;
        char previous = ind >= 0 ? c[ind] : ' ';
        for (int i = ind; i >= 0; i--) {
            if (c[i] == '/' && previous != '/')
                count++;
            previous = c[i];
        }

        return count + 1;
    }
}
