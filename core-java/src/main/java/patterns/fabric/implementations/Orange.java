package patterns.fabric.implementations;

import patterns.fabric.Product;

import java.util.Random;

class Orange implements Product {
    private static int counter = 1;

    @Override
    public String getName() {
        return "orange" + counter++;
    }

    @Override
    public int getWeight() {
        return new Random().nextInt(200);
    }
}
