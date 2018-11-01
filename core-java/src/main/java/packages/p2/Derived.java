package packages.p2;

import packages.p1.Base;

public class Derived extends Base {

    @Override
    protected void print() {
        super.print();
        System.out.println("Printing from Derived protected method print()");
    }

    public static void main(String[] args) {
        Base b = new Base();
        // won't compile because of "protected" access modifier.
//        b.print();

        Derived d = new Derived();
        d.print();
    }
}
