package collections.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Using some features of LinkedHashMap, simulating LRU cache with fixed size.
 */
public class LRUCache {

    public static void main(String[] args) {
        SomeCache<Integer, Integer> cache = new SomeCache<>();
        for (int i = 0; i < 15; i++) {
            cache.put(i, i);
        }
        cache.get(6);

        Iterator<Integer> i = cache.keySet().iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }

    private static final class SomeCache<K, V> extends LinkedHashMap<K, V> {
        private static final int MAX_CAPACITY = 20; // must not less than 16 because of internals of LinkedHashMap

        SomeCache(int initCapacity) {
            super(initCapacity > MAX_CAPACITY ? MAX_CAPACITY : initCapacity, .75f, true);
        }

        SomeCache() {
            super(MAX_CAPACITY,.75f,true);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > MAX_CAPACITY;
        }
    }
}


