package com.example.site.service;

import com.example.site.models.Dish;
import com.example.site.repositories.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishService {
    private DishRepository dishRepository;
    public List<Dish> getDishes(){
        return dishRepository.findAll();
    }
    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }
}
