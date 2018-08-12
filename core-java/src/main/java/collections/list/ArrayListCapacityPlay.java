package collections.list;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Used ugly reflection-hack. DON'T USE IT!
 */
public class ArrayListCapacityPlay {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(String.valueOf(i));
            System.out.format("Size: %2d, Capacity: %2d%n",
                    list.size(), getCapacity(list));
        }
        for (int i = 0; i < 200; i++) {
            list.remove(String.valueOf(i));
            System.out.format("Size: %2d, Capacity: %2d%n",
                    list.size(), getCapacity(list));
        }
    }

    private static int getCapacity(ArrayList<?> list) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(list)).length;
    }
}
