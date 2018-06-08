import exceptions.MyException;
import exceptions.writer.SimpleFileWriter;
import exceptions.writer.TryWithResourcesFileWriter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            TryWithResourcesFileWriter writer = new TryWithResourcesFileWriter();
            writer.setList(Arrays.asList(999, 666, 1418));
            writer.printList();
        } catch (MyException e) {
            
            StackTraceElement[] stackTraceElement = e.getStackTrace();
            for (StackTraceElement i : stackTraceElement) {
                System.err.println(
                        i.getFileName() + ": " + i.getLineNumber()
                        + " line >>> " + i.getMethodName() + "()");
            }
        }

    }
}
