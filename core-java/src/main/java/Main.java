import java.util.*;

public class Main {
    public static void main(String[] args) {
        f(getMap());
    }

    private static <K, V> Map<K, V> getMap() {
        return new HashMap<K, V>();
    }

    static void f(Map<String, List<? extends String>> petPeople) {}
}