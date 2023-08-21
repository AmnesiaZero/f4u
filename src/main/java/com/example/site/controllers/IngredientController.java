package com.example.site.controllers;

import com.example.site.models.Ingredient;
import com.example.site.service.IngredientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @GetMapping("/get-all-ingredients")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

}
