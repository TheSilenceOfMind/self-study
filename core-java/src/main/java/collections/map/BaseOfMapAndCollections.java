package collections.map;

import java.util.*;

import static java.util.Map.Entry;

/**
 * Just a class containing set of actoins with map:
 *  1) manipulation Map through Collections
 *  2) using bulk operation
 *
 */
public class BaseOfMapAndCollections {

    public static void main(String[] args) {
//        checkNewAttributeMap();
//        chechMapKeySetRemoval();
//        checkMapValuesEdition();
        checkMapEntriesSetEditting();
    }

    /**
     * Just an example of initializing of map with needed data from
     * given default map using bulk operation.
     */
    static <K, V> Map<K, V> newAttributeMap(Map<K, V> defaultMap, Map<K, V> needToUploadMap) {
        Map<K, V> map = new HashMap<>(defaultMap);
        map.putAll(needToUploadMap);
        return map;
    }

    /**
     * To test containedsAll operations with set.
     */
    static <K, V> boolean validate(Map<K, V> attrMap, Set<K> requiredAttrs, Set<K>permittedAttrs) {
        boolean valid = true;
        Set<K> attrs = attrMap.keySet();

        if (! attrs.containsAll(requiredAttrs)) {
            Set<K> missing = new HashSet<>(requiredAttrs);
            missing.removeAll(attrs);
            System.out.println("Missing attributes: " + missing);
            valid = false;
        }
        if (! permittedAttrs.containsAll(attrs)) {
            Set<K> illegal = new HashSet<>(attrs);
            illegal.removeAll(permittedAttrs);
            System.out.println("Illegal attributes: " + illegal);
            valid = false;
        }
        return valid;
    }

    private static void checkNewAttributeMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kirill", 1);
        map.put("Martin", 3);
        System.out.println("old map: " + map);

        Map<String, Integer> defMap = new HashMap<>();
        defMap.put("Kirill", 0);
        defMap.put("Tanya", 0);

        map = newAttributeMap(defMap, map);
        System.out.println("new map: " + map);
    }

    private static void chechMapKeySetRemoval() {
        Map<String, Integer> map = new HashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        System.out.println("origin map: " + map);

        Set<String> keys = map.keySet();
        System.out.println("keys: " + keys);

        keys.remove("first");
        System.out.println("after removing first element from keys set: " + map);
    }

    private static void checkMapValuesEdition() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 1);
        map.put("first", 2);
        map.put("second", 1);
        map.put("third", 3);
        System.out.println("origin map: " + map);

        Collection<Integer> values = map.values();
        System.out.println("values: " + values);

        values.removeIf(integer -> integer.equals(2));
        System.out.println("changed values: " + values);
        System.out.println("changed map: " + map);
    }

    private static void checkMapEntriesSetEditting() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("zero", 1);
        map.put("first", 2);
        map.put("second", 1);
        map.put("third", 3);
        System.out.println("origin map: " + map);

        Set<Entry<String, Integer>> set = map.entrySet();
        System.out.println("original set of entries: " + set);

        Iterator<Entry<String, Integer>> it = set.iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            if (entry.getValue().equals(1))
                entry.setValue(entry.getValue() + 100);
        }
        System.out.println("set after changes: " + set);
        System.out.println("map after changes: " + map);
    }

}
