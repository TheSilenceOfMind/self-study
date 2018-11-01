package exceptions.in_constructor;

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null)
                    ;
            } catch (Exception e) {
                System.out.println("Caught exception in main");
                e.printStackTrace(System.err);
            } finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.err.println("InputFile construction failed");
        }
    }
}
