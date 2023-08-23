package com.example.f4u.controllers;

import com.example.f4u.dtos.DishDTO;
import com.example.f4u.dtos.IngredientDTO;
import com.example.f4u.service.DishService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import com.example.f4u.models.Dish;
import lombok.extern.log4j.Log4j;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    public List<DishDTO> getDishesByIngredients(@RequestBody int[] ingredientsIds){
        log.info("get Dishes By Ingredients");
        log.info(Arrays.toString(ingredientsIds));
        return dishService.getDishesByIngredients(ingredientsIds);
    }
    @GetMapping("/get-total-calory")
    public int getTotalCalory(@RequestBody int dishId){
        log.debug("Dish id = " + dishId);
        return dishService.getTotalCalory(dishId);
    }


}
