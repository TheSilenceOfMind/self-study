package util;

import java.util.*;

public class FormatterDemo {
    public static void main(String[] args) {
        try (Formatter fmt = new Formatter()) {
            for (double d = 1.23; d < 1.0e+6; d *= 100) {
                fmt.format("%f %e ", d, d);
                System.out.println(fmt);
            }
        }
    }
}
