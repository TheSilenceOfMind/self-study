package nested;

public class Outer {
    class Inner {
        @Override
        public String toString() {
            return "inner class";
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String... args) {
        Outer o = new Outer();
        Outer.Inner oi = o.getInner();
        System.out.println(oi);
    }
}
