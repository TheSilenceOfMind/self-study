package java8.stream;

import java.util.*;
import java.util.function.*;

public class ReduceMethodDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(7, 18, 10, 24, 17, 5));

        BinaryOperator<Integer> func = (a, b) -> a * b;

        // there's 2 ways to obtain the product of the elements from collection using reduce of a stream.
        Optional<Integer> product = list.stream().reduce(func);
        System.out.println("product as optional: " + product.orElse(Integer.MAX_VALUE));

        int product2 = list.stream().reduce(1, func);
        System.out.println("product as int: " + product2);
    }
}
