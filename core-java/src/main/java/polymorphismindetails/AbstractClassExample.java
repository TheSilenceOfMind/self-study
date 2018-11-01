package polymorphismindetails;

abstract class BaseClass {
    BaseClass() {
        System.out.println("base constructor!");
    }

    public void print() {
        System.out.println("Hello from base class");
    }
}

class Derived extends BaseClass {
    Derived() {
        System.out.println("derived constructor!");
    }

    public void print() {
        System.out.println("Hello from derived class");
    }

    public void printSuper() {
        super.print();
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        BaseClass bc = new Derived();
        bc.print();
        ((Derived) bc).printSuper();
    }
}
