package ch4.aop.concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppByJavaConf {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        List<Performance> performers = new ArrayList<>(Arrays.asList(
                (Performance) context.getBean("actress"),
                (Performance) context.getBean("stuntman")
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
