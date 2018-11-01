package network;

import java.net.*;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        System.out.println("        VK.com:");
        InetAddress[] addresses = InetAddress.getAllByName("vk.com");
        for (InetAddress ia : addresses)
            System.out.println(ia);

        System.out.println();
        address = InetAddress.getByName("www.nba.com");
        System.out.println(address);
    }
}
