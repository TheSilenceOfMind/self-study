package generic.ocean;

import generic.Generator;
import java.util.*;

public class Ocean {
    static Generator<BigFish> big = BigFish.generator();
    static Generator<LittleFish> little = LittleFish.generator();

    public static void main(String[] args) {
        Queue<BigFish> bigs = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            bigs.add(big.next());
            little.next();
        }
    }
}

class BigFish {
    private static int counter = 0;
    private final int id = counter++;

    private BigFish() {
    }

    public String toString() {
        return "Big " + id;
    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            public BigFish next() { return new BigFish(); }
        };
    }
}

class LittleFish {
    private static int counter = 0;
    private final int id = counter++;

    private LittleFish() {
    }

    public String toString() {
        return "little " + id;
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}