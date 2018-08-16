package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc/config.xml");

        System.out.println(ioc.getBean("pocket", Pocket.class));
    }
}
