package network;

import java.net.*;
import java.io.*;
import java.util.Date;

public class UCDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.mail.ru");
        URLConnection conn = url.openConnection();

        System.out.println("Date: " + new Date(conn.getDate()));
        System.out.println("Content-Type: " + conn.getContentType());
        System.out.println("Expires: " + new Date(conn.getExpiration()));
        System.out.println("Last-modified: " + new Date(conn.getLastModified()));
        System.out.println("Content-Length: " + conn.getContentLength());

        if (conn.getContentLength() > 0) {
            System.out.println();
            System.out.println("===Content===");

            try (InputStream in = conn.getInputStream()) {
                int c;
                while ((c = in.read()) != -1)
                    System.out.print((char) c);
            }
        }
    }
}
