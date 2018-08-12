package java8.lambda;

public class SimpleExample {
    public static void main(String[] args) {
        ArrayFunc func = (n) -> {
            for (int i = 0; i < n.length; i++)
                System.out.println(n[i]);
        };

        func.func(new int[]{1, 2, 3});
    }

    private static void numericTest2Example() {
        NumericTest2 isFactor = (n, d) -> (n % d) == 0;
        System.out.println(isFactor.test(10, 2));
    }

    private static void numericTest1Example() {
        NumericTest isEven = (n) -> n % 2 == 0;
        System.out.println(isEven.test(6));
    }

    private static void testGetValue() {
        MyNumber myNumber;
        myNumber = () -> Math.random() * 100;

        System.out.println(myNumber.equals(myNumber));
    }
}

@FunctionalInterface
interface MyNumber {
    double getValue();
}

@FunctionalInterface
interface NumericTest {
    boolean test(int n);
}

@FunctionalInterface
interface NumericTest2 {
    boolean test(int n, int d);
}

@FunctionalInterface
interface ArrayFunc<T> {
    void func(int[] a);
}