package collections.set;

import java.util.Comparator;

public class TreeSetTest {
    public static void main(String... args) {
        java.util.TreeSet<String> t = new java.util.TreeSet<>((a, b) -> -a.compareTo(b));

        t.add("B");
        t.add("A");
        t.add("C");

        System.out.println(t);
    }
}
