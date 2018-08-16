package util;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        double sum = 0;
        int count = 0;
        InputStream fin = System.in;
        try (Scanner src = new Scanner(fin)) {
            // Read and sum numbers.
            while (src.hasNext()) {
                if (src.hasNextDouble()) {
                    sum += src.nextDouble();
                    count++;
                } else {
                    String str = src.next();
                    if (str.equals("done")) break;
                    else {
                        System.out.println("File format error.");
                        return;
                    }
                }
            }
        }
    }
}
