package ioc;

import java.util.Random;

class PocketFactory {
    Pocket producePocket() {
        return new Pocket(new Random().nextInt(1000));
    }
}
