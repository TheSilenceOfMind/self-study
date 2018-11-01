package nio;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DirTreeList {

    private static final String dirname = "src/main/";

    public static void main(String[] args) {
        System.out.println("Directory tree starting with " + dirname + ":\n");

        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor(getLevelNum(dirname) - 1));
        } catch (IOException exc) {
            System.out.println("I/O Error");
        }
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        final int initLvl;
        int depth;

        MyFileVisitor(int initLvl) {
            this.initLvl = initLvl;
            depth = 0;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            printTab();
            System.out.println(file.getName(initLvl + depth));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            printTab();
            System.out.println(dir.getName(initLvl + depth++));
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            depth--;
            return FileVisitResult.CONTINUE;
        }

        void printTab() {
            for (int i = 0; i < depth - 1; i++)
                System.out.print("    ");
            if (depth > 0)
                System.out.print("|---");
        }
    }

    private static int getLevelNum(String dirname) {
        char[] c = dirname.toCharArray();
        int ind = c.length - 1;
        int count = 0;

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
