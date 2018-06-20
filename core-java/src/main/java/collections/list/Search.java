package collections.list;

import java.util.*;

/**
 * Shows how use {@code Collections.binarySearch()}
 */
public class Search {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Collections.reverse(list);
        System.out.println("list: " + list);

        int pos = Collections.binarySearch(list, 10, Comparator.reverseOrder());
        if (pos < 0)
            System.out.println("no such element, it! It could be added at " + (-pos - 1) + " index");
        else
            System.out.println("found! index: " + pos);

    }
}
