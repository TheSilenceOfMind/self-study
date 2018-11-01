package rtti;

public class TestingClassLoader {
    public static void main(String[] args) {
        System.out.println("in main");
        new Gum();
        System.out.println("after creating gum");

        try {
            Class.forName("rtti.Fun");
        } catch (ClassNotFoundException e) {
            System.out.println("Class \"Fun\" not found!");
        }

    }
}

class Gum {
    static {
        System.out.println("loaded Gum");
    }
}

class Fun {
    static {
        System.out.println("loaded Fun");
    }
}
