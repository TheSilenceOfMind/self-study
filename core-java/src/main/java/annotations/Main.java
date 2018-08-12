package annotations;

@CustomAnnotation(123)
public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        printInfoAboutCustomAnnotation(app.getClass(), CustomAnnotation.class);
    }

    private static void printInfoAboutCustomAnnotation(Class<?> srcClass, Class<? extends CustomAnnotation> anno) {
        CustomAnnotation annotation = srcClass.getAnnotation(anno);
        System.out.println("str: " + annotation.str());
        System.out.println("value: " + annotation.value());
    }

}
