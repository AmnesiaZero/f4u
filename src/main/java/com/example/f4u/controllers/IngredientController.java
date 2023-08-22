package com.example.f4u.controllers;

import com.example.f4u.dtos.IngredientDTO;
import com.example.f4u.models.Ingredient;
import com.example.f4u.service.IngredientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @GetMapping("/main")
    public List<IngredientDTO> getIngredients(){
        return ingredientService.getIngredients();
    }

}
