package io.stream.buffered;

import java.io.*;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "This is a &copy; copytirght symbol but this is &copy not.\n";
        byte buffer[] = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        int c;
        boolean marked = false;

        try (BufferedInputStream f = new BufferedInputStream(in)) {
            while((c = f.read()) != -1) { // while not EOL
                switch(c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            System.out.print('&');
                        } else
                            System.out.print((char) c);
                        break;
                    default:
                        if (!marked)
                            System.out.print((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("I/O Error: " + e);
        }
    }
}
