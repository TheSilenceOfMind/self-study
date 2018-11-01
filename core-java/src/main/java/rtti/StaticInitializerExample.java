package rtti;

// just to test static initializer functionality while using inheritance
public class StaticInitializerExample {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    static {
        System.out.println("A");
    }

    public A() {
        System.out.println("A constructor");
    }
}

class B extends A {
    static {
        System.out.println("B");
    }

    public B() {
        System.out.println("B constructor");
    }
}
