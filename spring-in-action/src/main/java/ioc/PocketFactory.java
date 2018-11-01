package ioc;

import java.util.Random;

public class PocketFactory {
    public PocketSubclass producePocket() {
        return new PocketSubclass(1000);
    }
}
