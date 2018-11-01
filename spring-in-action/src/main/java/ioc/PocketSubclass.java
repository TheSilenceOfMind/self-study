package ioc;

public class PocketSubclass extends Pocket {

    PocketSubclass(int money) {
        super(money);
    }

    @Override
    protected void print() {
        System.out.println("subclass print()");
    }
}
