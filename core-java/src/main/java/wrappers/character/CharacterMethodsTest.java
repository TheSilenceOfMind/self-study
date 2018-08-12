package wrappers.character;

import java.io.IOException;

public class CharacterMethodsTest {
    public static void main(String[] args) throws IOException {
        char c = (char) System.in.read();
        System.out.println("Hashcode: " + Character.valueOf(c).hashCode());
        System.out.println("Code: " + Character.getNumericValue(c));
    }
}
