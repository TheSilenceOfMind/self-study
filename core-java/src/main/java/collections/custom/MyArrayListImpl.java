package collections.custom;

import java.util.AbstractList;
import java.util.List;

/**
 * class-fabric to init MyArrayListImpl object by static public methods (as Arrays class does).
 */
public class MyArrayListImpl {
    public static <T> List<T> asList(T... a) {
        return new MyArrayList<T>(a);
    }

    private static final class MyArrayList<T> extends AbstractList<T> {
        private final T[] array;

        MyArrayList(T... a) {
            this.array = a;
        }

        @Override
        public T get(int index) {
            return array[index];
        }

        @Override
        public int size() {
            return array.length;
        }

        @Override
        public T set(int index, T element) {
            T beforeSet = array[index];
            array[index] = element;
            return beforeSet;
        }

        @Override
        public Object[] toArray() {
            return array.clone();
        }
    }
}
