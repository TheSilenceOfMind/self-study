package collections.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class FindDuplicates {

    public static void main(String... args) {
        useForEachWithHashTable();
    }

    private static void useAggregationFunc(String... args) {
        Set<String> c = Arrays.asList(args)
                .stream()
                .collect(Collectors.toSet());
        System.out.printf("size %d%nelems: %s%n", c.size(), c);
    }

    private static void useForEachWithHashTable(String... args) {
        Set<String> c = new HashSet<>(Arrays.asList(args));
        System.out.printf("size %d%nelems: %s%n", c.size(), c);
    }
}
