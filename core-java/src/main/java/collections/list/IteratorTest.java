package collections.list;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
//        testIterator();
//        printListUsingListIterator(Arrays.asList(3, 4, 2, 1, 9));
    }

    private static void testIterator() {
        ArrayList<String> list = new ArrayList<>();

        list.addAll(Arrays.asList("A", "B", "C"));
        Iterator<String> it = list.iterator();

        System.out.println(list);
//        it.next();
        it.remove(); // raises UnsupportedOperationException if previous line is commented.
        System.out.println(list);
    }

    private static void printListUsingListIterator(List<?> list) {
        ListIterator<?> li = list.listIterator();
        while (li.hasNext())
            System.out.printf("index: %3d | element: %s%n", li.nextIndex(), li.next());
    }
}
