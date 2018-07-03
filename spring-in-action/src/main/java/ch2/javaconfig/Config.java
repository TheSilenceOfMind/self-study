package ch2.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {

    @Bean(name="someCD")
    CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean("somePlayer")
    MediaPlayer cdPlayer() {
        MediaPlayer player = new CDPlayer(sgtPeppers());
        // put some business logic here
        return player;
    }

}
