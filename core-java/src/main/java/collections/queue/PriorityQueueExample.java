package collections.queue;

import java.util.*;

/**
 * The example shows how PQ sorts values in heap while add them using specified comparator.
 * As it shown below we can't be sure about order of elements in PQ (WOW CAP! Because they are sorted be
 * specified comparator! What a mystery! :D )
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            if (o1 > o2)
                return -1;
            if (o1 < o2)
                return 1;
            return 0;
        });
        q.addAll(Arrays.asList(1, 2, 3, 4, 5));

        // let's see original order in PQ
        Integer[] array = Arrays.stream(q.toArray())
                .map(Object::toString)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        System.out.println("original order of PQ: " + Arrays.toString(array));
        // and now sort it and print
        Arrays.sort(array);
        System.out.println("sorted order: " + Arrays.toString(array));
    }
}
