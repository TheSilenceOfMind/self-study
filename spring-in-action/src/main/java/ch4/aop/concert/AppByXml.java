package ch4.aop.concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppByXml {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4/aop/concert/config.xml");
        List<Performance> performers = new ArrayList<>(Arrays.asList(
                (Performance) context.getBean("ch4.aop.concert.Actress#0"),
                (Performance) context.getBean("ch4.aop.concert.Stuntman#0")
        ));

        for (Performance p : performers) {
            try {
                p.perform();
            } catch (IllegalStateException e) {
                System.err.printf(
                        "=============================================================%n" +
                                "needed refund!%n" +
                                "=============================================================%n");
            }
        }
    }
}
