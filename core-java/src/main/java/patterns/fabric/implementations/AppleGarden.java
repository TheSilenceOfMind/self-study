package patterns.fabric.implementations;

import patterns.fabric.Product;
import patterns.fabric.Provider;

public class AppleGarden implements Provider {

    private int fruitfulness = 2;
    private int produced = 0;

    @Override
    public Product getProduct() {
        if (produced >= fruitfulness)
            return null;
        produced++;
        return new Apple();
    }
}
