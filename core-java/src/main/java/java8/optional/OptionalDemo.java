package java8.optional;

import java.util.*;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty();
        Optional<String> hasVal = Optional.of("ABCDEF");

        if (noVal.isPresent())
            System.out.println("It won't be printed");
        else
            System.out.println("noVal is empty");

        String defStr = noVal.orElse("Default String");
        System.out.println(defStr);
    }
}
