package io.stream;

import java.io.*;

public class CountLetter {

    private String filename;

    public CountLetter(String filename) {
        this.filename = filename;
    }

    public int countOccurrences(char c) {
        int counter = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String str = in.readLine();
            while (str != null) {
                for (char i : str.toCharArray())
                    if (i == c)
                        counter++;
                str = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

}
