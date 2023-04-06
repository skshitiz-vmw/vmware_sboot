package com.examples.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public Car bmw() {
//        return new Car("White", "X7", "BMW", electric());
//        return new Car(carConfig.getColor(), carConfig.getModel(), carConfig.getManufacturer(), petrol());
        return new Car(petrol());
    }
    @Bean
    public Engine petrol() {
        return new Engine(3000, 6, 700);
    }

    @Bean
    public Engine diesel() {
        return new Engine(4000, 6, 800);
    }

    @Bean
    public Engine electric() {
        return new Engine(6000, 6, 700);
    }
}
