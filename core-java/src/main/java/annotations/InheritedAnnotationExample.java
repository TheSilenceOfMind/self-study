package annotations;

/**
 * Shows usage of @Inherited annotation.
 */
public class InheritedAnnotationExample {

    public static void main(String... args) {
        Parent parent = new Parent();
        Child child = new Child();

        System.out.println("Is SuperclassAnnotation presented within:");
        System.out.println("\tparent: " + parent.getClass().isAnnotationPresent(SuperclassAnnotation.class));
        System.out.println("\tchild: " + child.getClass().isAnnotationPresent(SuperclassAnnotation.class));

        System.out.println("Is CustomAnnotation presented within:");
        System.out.println("\tparent: " + parent.getClass().isAnnotationPresent(CustomAnnotation.class));
        System.out.println("\tchild: " + child.getClass().isAnnotationPresent(CustomAnnotation.class));
    }

    @SuperclassAnnotation
    @CustomAnnotation(0)
    private static class Parent { }

    private static class Child extends Parent { }
}
