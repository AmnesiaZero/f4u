package com.example.f4u.controllers;

import com.example.f4u.models.Ingredient;
import com.example.f4u.service.DishService;
import lombok.Data;
import com.example.f4u.models.Dish;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Log4j
@RestController
@RequestMapping("/dishes")
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping("/get-all-dishes")
    public List<Dish> getDishes(){
        return dishService.getDishes();
    }
    @PostMapping("/get-dishes-by-ingredients")
    public List<Dish> getDishesByIngredients(@RequestBody List<Ingredient> ingredients){
        log.info("get Dishes By Ingredients");
        return dishService.getDishesByIngredients(ingredients);
    }

}
