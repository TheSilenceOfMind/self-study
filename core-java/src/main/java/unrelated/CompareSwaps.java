package unrelated;

/**
 * Compare performance by execution time of 2 swaps without additional accumulator:
 * 1) by xor
 * 2) by summarizing and subtracting arithmetic operations
 *
 * Conclusion:
 * xor is much slower (approximately in 100 times) than arithmetic operations.
 * Probably result is caused by code optimization made by "ordinary" compiler and/or JIT compiler.
 */
public class CompareSwaps {
    public static void main(String[] args) {
        Integer a = 0b1001; // 9
        Integer b = 0b1101; // 13
        CustomPair pair = new CustomPair(a, b);
        System.out.println("origin pair: " + pair);

        Swapper xorSwapper = new SwapperByXor();
        Swapper arithSwapper = new SwapperByArithmeticOperations();

        System.out.println("xor: " + measureDiffInNanoSec(xorSwapper, pair));
        System.out.println(pair);
        System.out.println();

        System.out.println("arithmetic: " + measureDiffInNanoSec(arithSwapper, pair));
        System.out.println(pair);
        System.out.println();

        final int counter = 100;
        long byXor = 0;
        long byArithm = 0;
        for (int i = 0; i < counter; i++) {
            byXor += measureDiffInNanoSec(xorSwapper, pair);
            byArithm += measureDiffInNanoSec(arithSwapper, pair);
        }
        System.out.println("xor aver: " + (double) byXor / counter);
        System.out.println("arithmetic aver: " + (double) byArithm / counter);
    }

    static final class CustomPair {
        int a;
        int b;

        CustomPair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return String.format("{%d, %d}", a, b);
        }
    }

    interface Swapper {
        void swap(CustomPair pair);
    }

    static class SwapperByXor implements Swapper {
        @Override
        public void swap(CustomPair pair) {
            pair.a = pair.a ^ pair.b; // a = abs(a-b)
            pair.b = pair.a ^ pair.b; // b = b - (a - b) = a_original
            pair.a = pair.a ^ pair.b;
        }
    }

    static class SwapperByArithmeticOperations implements Swapper {
        @Override
        public void swap(CustomPair pair) {
            pair.a = pair.a + pair.b;
            pair.b = pair.a - pair.b;
            pair.a = pair.a - pair.b;
        }
    }

    private static <T extends Swapper> long measureDiffInNanoSec(T swapper, CustomPair pair) {
        long start = System.nanoTime();
        swapper.swap(pair);
        long end = System.nanoTime();
        return end - start;
    }
}
