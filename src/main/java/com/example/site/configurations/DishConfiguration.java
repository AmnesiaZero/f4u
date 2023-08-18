package com.example.site.configurations;

import com.example.site.models.Dish;
import com.example.site.repositories.DishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DishConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(DishRepository dishRepository){
        return args -> {
            Dish salad = new Dish("salad",50);
            Dish soup = new Dish("soup",100);
            dishRepository.saveAll(List.of(salad,soup));
        };

    }
}
