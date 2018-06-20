package collections.wrappers;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());
        for (int i = 0; i < 10; i++) {
            syncMap.put(i, i);
        }
        Set<Integer> keys = syncMap.keySet();

        synchronized (syncMap) { // ALERT! use original collection rather than set/list while using map
            for (Integer i : keys)
                System.out.println(i);
        }
    }
}
