package collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Just to test "famous" convention.
 * same hashcode AND equals on key -> the same entry
 */
public class UnderstandingOfEqualsAndHashCode {
    public static void main(String[] args) {
        Map<MyObject, Integer> map = new HashMap<>();
        MyObject o1 = new MyObject("Hello");
        MyObject o2 = new MyObject("World");
        map.put(o1, 1);
        System.out.println(map);
        map.put(o2, 2);
        System.out.println(map);
    }

    private static final class MyObject {
        String field;

        MyObject(String f) {
            field = f;
        }

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return field;
        }
    }
}
