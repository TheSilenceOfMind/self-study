package reflection;

import java.lang.Class;
import java.util.*;

public class TestingClassClass {
    public static void main(String[] args)  {
        try {
//            testTypeFieldOfClass();
//            testGetClassesMethod();
            testGetDeclaredClasses();
        } catch (Exception e) { e.printStackTrace();}
    }

    static class Test {
        public void testMethod() { }
    }

    private static void testTypeFieldOfClass() throws NoSuchMethodException {
        Class myVoid = Test.class.getMethod("testMethod", null).getReturnType();
        System.out.println(myVoid == Void.TYPE);
        System.out.println(myVoid == Void.class); // Void.class != void.class
        System.out.println(myVoid == void.class); // Void.TYPE == void.class (see docs)
    }

    private static void testGetClassesMethod() {
        Class<?>[] nestedClasses = Character.class.getClasses();
        for (Class<?> c : nestedClasses) {
            System.out.println(c.getName());
        }
    }

    private static void testGetDeclaredClasses() {
        Class<?>[] declaredClasses = TestingClassClass.class.getDeclaredClasses();
        for (Class<?> c : declaredClasses) {
            System.out.println(c.getName());
        }
    }
}
