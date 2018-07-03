package ch2.mixconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath*:ch2/mixconfig/cd-config.xml")
class SoundSystemConfig {
}
