package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc/config.xml");

        Pocket ps = ioc.getBean("pocket", Pocket.class);
        ps.print();
        System.out.println("Total amount of money in pocket: " + ps);
    }
}
