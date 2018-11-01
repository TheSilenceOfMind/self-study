package generic;

import java.util.*;

public class Tmp {
    public static void main(String[] args) {
        getSomeType(new Type(), null);
    }

    static <SomeType, V> generic.Type getSomeType(SomeType arg, List<V> someList) {
        if (arg instanceof Type)
            System.out.println("YES");
        return new generic.Type();
    }
}

class Type {}
