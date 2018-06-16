package collections.generators;

import java.util.stream.IntStream;

/**
 * The example shows power of lambda expression and using aggregation in Java 8
 */
public class Example {

    private static final int INT_VALUE = 1;
    private static final int END_VALUE = 10;

    public static void main(String[] args) {
        IntStream myStream = IntStream.iterate(INT_VALUE, a -> a + 1);
        myStream
                .limit(END_VALUE)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);
    }
}
