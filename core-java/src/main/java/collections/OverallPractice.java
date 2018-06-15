package collections;

import java.nio.charset.Charset;
import java.util.*;

/**
 * The class contains some comparison between aggregation and foreach performance while working with List
 * in the same manner. As it was found parallel streams sometimes could be faster than using simple for-loop.
 * But sequence streams are not faster at all. It is so because optimization of for-loop supported by JIT-compiler and
 * features of sequence streams. USE PARALLEL STREAM, only this could improve performance of the program.
 */
public class OverallPractice {
    private static final int ELEMENTS_NUM = 1_000_000;

    public static void main(String[] args) {
        // generate a lot of String objects to pass them all to list
        String[] array = new String[ELEMENTS_NUM];
        for (int i = 0; i < array.length; i++) {
            byte[] futureString = new byte[7]; // length is bounded by 7
            new Random().nextBytes(futureString);
            String generatedString = new String(futureString, Charset.forName("UTF-8"));
            array[i] = generatedString;
        }

        List<String> list = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(list);

        long fromA = System.nanoTime();
        printListUsingAggregation(list);
        long toA = System.nanoTime();

        long from = System.nanoTime();
        printListUsingForEach(list);
        long to = System.nanoTime();
        System.out.println("Estimated time of aggregation using: " + (toA - fromA) / 1e6 + "ms");
        System.out.println("Estimated time of foreach using: " + (to - from) / 1e6 + "ms");
    }

    /**
     * Used an aggregation stream func to print to stdout the specified collection items.
     *
     * @param collection specified collection
     * @param <T>        generic type
     */
    private static <T> void printListUsingAggregation(Collection<T> collection) {
        if (collection == null)
            throw new NullPointerException("Expected collection object, got null!");
        StringBuilder sb = new StringBuilder();
        sb.append("collection: {");
        collection.stream()
                .parallel()
                .forEach(e -> sb.append(e.toString()).append(", "));
        // remove redundant comma and space
        if (collection.size() != 0)
            sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");
        System.out.println(sb);
    }

    /**
     * Used to dummy iteration and printing the result at the end of iteration.
     * If collections are quite huge, then storing at the end won't mess up output on stdout
     *
     * @param collection specified collection
     * @param <T>        Generic type
     */
    private static <T> void printListUsingForEach(Collection<T> collection) {
        if (collection == null)
            throw new NullPointerException("Expected collection object, got null!");
        StringBuilder sb = new StringBuilder();
        sb.append("collection: {");
        for (T element : collection) {
            sb
                    .append(element.toString())
                    .append(", ");
        }
        // remove redundant comma and space
        if (collection.size() != 0)
            sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("}");

        System.out.println(sb);
    }

}
