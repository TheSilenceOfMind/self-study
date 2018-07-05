package org.practice.spitter.config;

import org.practice.spitter.Spitter;
import org.practice.spitter.Spittle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

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
        String[] list = {"Spittes go fourth!", "second message text!", "hey, spitters!", "4-th spitter",
                "WHAT'S GOING ON?!"};
        for (String s : list) {
            ret.add(new Spittle(s, new Date()));
        }
        return ret;
    }

    @Bean
    public Set<Spitter> getDefaultSpittersSet() {
        return new HashSet<>(Arrays.asList(
                new Spitter("Kirill", "Balad", "user0", "passwd"),
                new Spitter("John", "Johnson", "user1", "passwd")
        ));
    }
}
