package io.stream;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderExample {
    public static void main(String... args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        char c;
        try {
            System.out.println("Enter 'q' to exit from endless loop. Enter the sequence of chars: ");
            do {
                c = (char) inputStreamReader.read();
                System.out.println(c);
            } while (c != 'q');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
