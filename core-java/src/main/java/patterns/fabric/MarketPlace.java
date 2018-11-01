package patterns.fabric;

import patterns.fabric.implementations.AppleGarden;
import patterns.fabric.implementations.OrangeGarden;

public class MarketPlace {
    public static void main(String[] args) {
        Provider providers[] = {new AppleGarden(), new OrangeGarden()};
        try {
            for (int i = 0; i < 3; i++) {
                for (Provider p : providers) {
                    Product product = p.getProduct();

                    System.out.println(product.getName());
                    System.out.println(product.getWeight());
                    System.out.println();
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Product has ended...");
        }

    }
}
