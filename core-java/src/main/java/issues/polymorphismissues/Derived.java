package issues.polymorphismissues;

// the example shows pitfalls of using runtime method binding while initialising constructor.
class Base {
    Base() {
        System.out.println("Base() before say()");
        say();
        System.out.println("Base() after say()");
    }

    public void say() {
        System.out.println("Base said.");
    }
}

public class Derived extends Base {
    private int r = 5; // change to static and it will initialized.

    Derived(int r) {
        this.r = r;
        System.out.println("Derived class constructor: r = " + r);
    }

    @Override
    public void say() {
        System.out.println("Derived class said: r = " + r);
    }

    public static void main(String[] args) {
        new Derived(1);
    }
}


