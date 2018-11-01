package generic;

import java.util.*;

public class CompilerIntelligence {
    public static void main(String... args) {
        Integer intNum = 2;

        List<? extends Integer> list = Arrays.asList(intNum);
        list.contains(intNum);
    }
}
