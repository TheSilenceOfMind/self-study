package io.stream.sequenceIS;

import java.io.*;
import java.util.*;

public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>(Arrays.asList(
                "src/main/java/io/stream/sequenceIS/file1.txt",
                "src/main/java/io/stream/sequenceIS/file2.txt",
                "src/main/java/io/stream/sequenceIS/file3.txt"));

        InputStreamEnumerator inputStreamEnumerator = new InputStreamEnumerator(files);

        try(InputStream in = new SequenceInputStream(inputStreamEnumerator)) {
            while ((c = in.read()) != -1)
                System.out.print((char) c);
        } catch(IOException e) {
            System.err.println("IO error.");
        } catch(NullPointerException e) {
            System.err.println("Error opening file.");
        }
    }
}

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private Enumeration<String> filenames;

    public InputStreamEnumerator(Vector<String> filenames) {
        this.filenames = filenames.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return filenames.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(filenames.nextElement());
        } catch(IOException e) {
            return null;
        }
    }
}
