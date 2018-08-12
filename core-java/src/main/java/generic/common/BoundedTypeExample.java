package generic.common;

// super won't work with generic while defining class/method
public class BoundedTypeExample<T extends Number> {
    public static void main(String[] args) {

    }

    private T nubmer;


    // super works only with argument type.
    private static double getPowered(BoundedTypeExample<? super Double> example, int pow) {
        return Math.pow(example.getNumber().doubleValue(), pow);
    }

    public T getNumber() {
        return nubmer;
    }
}
