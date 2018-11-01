package util.concurrent.executors;

import java.util.concurrent.*;
import java.util.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        List<Future<Long>> results = new ArrayList<>();

        System.out.println("Glyph started!");
        for (int i = 0; i < 5; i++) {
            results.add(ex.submit(new FactorialThread(1 + i)));
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.printf("FactorialThread(%d) returned: %d%n", 1 + i, results.get(i).get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        ex.shutdown();
        System.out.println("Glyph done!");
    }
}

class FactorialThread implements Callable<Long> {
    int index;

    public FactorialThread(int index) {
        this.index = index;
    }

    @Override
    public Long call() throws InterruptedException {
        System.out.printf("FactorialThread(%d) is computing...%n", index);
        Long res = getFact(index);
        System.out.printf("FactorialThread(%d) ended computing!%n", index);
        return res;
    }

    long getFact(int index) throws InterruptedException {
        Thread.sleep(1000);
        if (index == 1)
            return 1;
        return (long) index * getFact(index - 1);
    }
}
