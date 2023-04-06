package com.examples.boot;

import com.examples.boot.Greetings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingsConfig {
    @Bean
    public Greetings greetings() {
        return new Greetings("Welcome to Spring Boot!!!");
    }
}
