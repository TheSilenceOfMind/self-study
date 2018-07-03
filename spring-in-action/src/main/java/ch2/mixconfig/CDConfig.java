package ch2.mixconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CDConfig {

    @Bean
    CompactDisc compactDisc() {
        return new SgtPeppers();
    }

}
