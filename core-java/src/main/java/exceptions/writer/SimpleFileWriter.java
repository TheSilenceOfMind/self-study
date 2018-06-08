package exceptions.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SimpleFileWriter {

    private List<Integer> list;
    private static final String FILENAME = "output.log";

    public void printList() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new File(FILENAME));
            for (int i = 0; i < list.size(); i++) {
                out.printf("[%d] %d%n", i, list.get(i));
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (out == null)
                System.out.println("File was not open");
            else {
                System.out.println("Closing File...");
                out.close();
            }
        }
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
