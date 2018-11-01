package java8.stream;

import java.util.*;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(7, 18, 10, 24, 17, 5));
        System.out.println("Original list: " + list);
        System.out.println();

        Stream<Integer> stream = list.stream();

        Optional<Integer> minVal = stream.min(Integer::compareTo);
        System.out.println("Min value : " + minVal.orElse(Integer.MAX_VALUE));

        stream = list.stream();
        Optional<Integer> maxVal = stream.max(Integer::compareTo);
        System.out.println("Max value : " + maxVal.orElse(Integer.MIN_VALUE));
        System.out.println();

        stream = list.stream().sorted();
        System.out.println("Sorted stream: ");
        stream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        Stream<Integer> oddVals = list.stream().sorted().filter((n) -> (n % 2) == 1);
        System.out.println("Odd values");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        oddVals = list.stream().filter((n) -> (n % 2) == 1)
                .filter((n) -> n > 5);
        System.out.println("odd values greater than 5: ");
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}
