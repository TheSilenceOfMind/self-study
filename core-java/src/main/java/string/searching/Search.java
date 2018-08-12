package string.searching;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private static List<Integer> findPatternOccurrences(String str, String pattern) {
        int startInd = 0;
        List<Integer> positions = new ArrayList<>();
        do {
            startInd = str.indexOf(pattern, startInd) + 1;
            positions.add(startInd - 1);
        } while (startInd != 0);
        positions.remove(positions.size() - 1);
        return positions;
    }

    public static void main(String... args) {
        String str = "hello, world, hello, hehehe";
        System.out.println(findPatternOccurrences(str, "he"));
    }
}
