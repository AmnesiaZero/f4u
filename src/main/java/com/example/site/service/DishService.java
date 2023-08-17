package com.example.site.service;

import com.example.site.models.Dish;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DishService {
    public List<Dish> getDish(){
        return List.of(new Dish(1,"Салат",10));
    }

}
