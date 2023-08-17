package com.example.site.service;

import com.example.site.models.Dish;
import com.example.site.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    public List<Dish> getDish(){
        return dishRepository.findAll();
    }

}
