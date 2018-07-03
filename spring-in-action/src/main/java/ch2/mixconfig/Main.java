package ch2.mixconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        MediaPlayer player = context.getBean(CDPlayer.class);
        player.play();
    }
}
