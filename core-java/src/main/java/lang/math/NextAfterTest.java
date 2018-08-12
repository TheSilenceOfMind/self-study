package lang.math;

public class NextAfterTest {
    public static void main(String[] args) {
//        testNextAfter();
//        testRing();
//        testUlpDouble();

    }

    private static void testUlpDouble() {
        double num = 1.57;
        double delta1 = Math.ulp(num);
        System.out.println("Math.ulp(" + num + ") = " + delta1);
        num = Math.nextUp(num);
        double delta2 = Math.ulp(num);
        System.out.println("Math.ulp(" + num + ") = " + delta2);
        if (Double.compare(delta1, delta2) == 0)
            System.out.println("delta is the same");
        else
            System.out.println("delta is different in both cases");
    }

    private static void testRing() {
        double num = 1.433;
        System.out.println("Math.rint() result: " + Math.rint(num));
    }

    private static void testNextAfter() {
        double start = 1.57;
        double target = 3.54;
        for (int i = 0; i < 100; i++) {
            start = Math.nextAfter(start, target);
            System.out.println(start);
        }
        System.out.println(start - 1.57);
    }
}
