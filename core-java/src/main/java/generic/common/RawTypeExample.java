package generic.common;

import java.util.ArrayList;

public class RawTypeExample {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);

        System.out.println((double)list.get(0));
    }
}
