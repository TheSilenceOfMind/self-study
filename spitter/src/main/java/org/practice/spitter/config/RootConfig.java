package org.practice.spitter.config;

import org.practice.spitter.Spittle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@ComponentScan(
        basePackages = {"org.practice.spitter"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
        })
public class RootConfig {
    @Bean
    public List<Spittle> getDefaultSpittleList() {
        List<Spittle> ret = new ArrayList<>();
        String[] list = {"Spittes go fourth!", "second message text!", "hey, spitters!"};
        for (String s : list) {
            ret.add(new Spittle(s, new Date()));
        }
        return ret;
    }
}
