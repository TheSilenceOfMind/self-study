package generic;

import java.util.Iterator;
import java.util.function.Consumer;

public class IterableFibonacci implements Generator<Integer>, Iterable<Integer> {

    Fibonacci fb;
    int n;

    public IterableFibonacci(Fibonacci fb) {
        this.fb = fb;
    }

    public IterableFibonacci(Fibonacci fb, int n) {
        this.fb = fb;
        this.n = n;
    }

    public IterableFibonacci(int n) {
        fb = new Fibonacci();
        this.n = n;
    }

    @Override
    public Integer next() {
        return fb.next();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return (n > 0);
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            @Override
            public void forEachRemaining(Consumer<? super Integer> action) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for(int i : new IterableFibonacci(18))
            System.out.print(i + " ");
    }
}
