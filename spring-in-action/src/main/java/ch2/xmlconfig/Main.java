package ch2.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch2/xmlconfig/config.xml");
        MediaPlayer player = context.getBean(CDPlayer.class);
        player.play();
    }
}
