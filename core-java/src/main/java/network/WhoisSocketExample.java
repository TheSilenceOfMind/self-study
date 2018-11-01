package network;

import java.io.*;
import java.net.*;

public class WhoisSocketExample {
    public static void main(String[] args) {
        try (Socket socket = new Socket("whois.internic.net", 43)) {

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // construct a req string
            String str = (args.length == 0 ? "vk.com" : args[0]) + "\n";
            byte[] bytes = str.getBytes();

            out.write(bytes);

            int c;
            while ((c = in.read()) != -1)
                System.out.print((char) c);

        } catch (IOException e) {
            System.err.println("IOException while using socket: " + e);
        }
    }
}
