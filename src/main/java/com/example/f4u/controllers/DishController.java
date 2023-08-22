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

import java.util.List;

@Data
@Log4j
@RestController
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping("/get-all-dishes")
    public List<Dish> getDishes(){
        return dishService.getDishes();
    }
    @PostMapping("/get-dishes-by-ingredients")
    public List<DishDTO> getDishesByIngredients(@RequestBody String ingredientsJson){
        log.info("get Dishes By Ingredients");
        log.info("JSON:" + ingredientsJson);
//        List<IngredientDTO> ingredientDTOS = new ObjectMapper().readValue(ingredientsJson, new TypeReference<List<DishDTO>>(){});
        List<IngredientDTO> ingredientDTOS = List.of(new IngredientDTO("Капуста"),new IngredientDTO("Курица"),new IngredientDTO("Морковь"));
        return dishService.getDishesByIngredients(ingredientDTOS);

    }

}
