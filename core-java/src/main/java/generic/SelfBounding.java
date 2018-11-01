package generic;

class SelfBounded<T extends SelfBounded<T>> {
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() { return element; }
}

// will compile
class A extends SelfBounded<A> { }

// will compile
class B extends SelfBounded<A> { }

class C {}
// won't compile
//class D extends SelfBounded<C> { }

// we can do next, can't force the idiom
class E extends SelfBounded {}

public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.set(new A()).get();
        a = a.get();
    }
}