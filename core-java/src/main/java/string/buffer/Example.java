package string.buffer;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.setLength(50);
        buffer.ensureCapacity(100);
        System.out.println(Arrays.toString(buffer.toString().getBytes()));
    }
}
