package java8.stream;

import java.util.*;

public class ParallelStreamReduceDemo {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(Arrays.asList(7., 18., 10., 24., 17., 5.));

        double productOfSqrtRoots = list.stream().parallel().reduce(1.0,
                (a, b) -> a * Math.sqrt(b),
                (a, b) -> a * b);
        System.out.println("result of products: " + productOfSqrtRoots);
    }
}
