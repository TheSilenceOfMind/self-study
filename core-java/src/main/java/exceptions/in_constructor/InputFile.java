package exceptions.in_constructor;

import java.io.*;

public class InputFile {

    private BufferedReader in;

    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open: " + fname);
            throw e;
        } catch (Exception e) {
            // we are not sure if "in" variable is initialized
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() unsuccessful");
            }
            // every time we throw exception further in order user can analyze problem of creation the object.
            throw e;
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            // throws unchecked in order to permit user don't accomplish with the exception
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
