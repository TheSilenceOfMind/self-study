package java8.stream;

import java.util.*;
import java.util.stream.*;

public class MapMethodDemo {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(Arrays.asList(7., 18., 10., 24., 17., 5.));

        Optional<Double> productOfRootsOptional = list.stream().map(Math::sqrt).reduce((a, b) -> a * b);
        System.out.println(productOfRootsOptional.orElse(Double.NaN));
    }
}
