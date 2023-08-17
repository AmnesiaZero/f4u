package com.example.site.configurations;

import com.example.site.repositories.DishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DishConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(DishRepository dishRepository){
        return args -> {

        };
    }
}
