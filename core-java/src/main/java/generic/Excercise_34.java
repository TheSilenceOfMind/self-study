package generic;

public class Excercise_34 {
    public static void main(String[] args) {
        Derived d = new Derived();
        d.g(d);
    }
}

abstract class Base<T extends Base<T>> {
    abstract T f(T arg);

    T g(T arg) {
        System.out.println(arg);
        return f(arg);
    }
}

class Derived extends Base<Derived> {
    @Override
    Derived f(Derived arg) {
        System.out.println(arg);
        return null;
    }
}