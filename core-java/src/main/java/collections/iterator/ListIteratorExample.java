package collections.iterator;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            l1.add(i);

        List<Integer> l2 = new ArrayList<>(l1.size());

        System.out.println("original list: " + l1);
        System.out.println("created list: " + l2);
    }
}

