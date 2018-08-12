package lang.object;

public class CloneTest implements Cloneable {

    int a;
    double b;

    CloneTest cloneTest() {
        try {
            return (CloneTest) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("clone not supported");
            return this;
        }
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static void main(String[] args) {
        CloneTest x1 = new CloneTest();
        x1.a = 5;
        x1.b = 20.2;

        CloneTest x2 = x1.cloneTest();

        System.out.println(x2);
    }
}
