package string;

import java.nio.charset.Charset;
import java.util.Arrays;

public class GetBytesExample {
    public static void main(String[] args) {
        byte[] stringBytes = "Hello, world!".getBytes();
        System.out.println(Arrays.toString(stringBytes));
    }
}
