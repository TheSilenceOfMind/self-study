package patterns.fabric.implementations;

import patterns.fabric.Product;
import patterns.fabric.Provider;

public class OrangeGarden implements Provider {

    @Override
    public Product getProduct() {
        return new Orange();
    }
}
