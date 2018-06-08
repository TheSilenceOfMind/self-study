package exceptions.writer;

import exceptions.MyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class TryWithResourcesFileWriter {

    private List<Integer> list;
    private static final String FILENAME = "output.log";

    public void printList() throws MyException {
        try (PrintWriter out = new PrintWriter(new File(FILENAME))) {
            for (int i = 0; i < list.size(); i++) {
                out.printf("[%d] %d%n", i, list.get(i));
            }
            throw new FileNotFoundException("I've done it by hardcode :D");
        } catch (FileNotFoundException exception) {
            MyException myException = new MyException("just to test exception :)");
            myException.initCause(exception);
            throw myException;
        }
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

}
