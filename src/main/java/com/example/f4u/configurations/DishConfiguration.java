package com.example.f4u.configurations;

import com.example.f4u.repositories.DishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DishConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(DishRepository dishRepository){
        return args -> {
//            Dish salad = new Dish("salad",50);
//            Dish soup = new Dish("soup",100);
//            dishRepository.saveAll(List.of(salad,soup));
        };

    }
}
