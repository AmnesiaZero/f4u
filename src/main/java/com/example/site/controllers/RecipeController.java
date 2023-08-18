package com.example.site.controllers;

import com.example.site.models.Recipe;
import com.example.site.service.RecipeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @GetMapping("/get")
    public List<Recipe> getRecipe(){
        return recipeService.getRecipes();
    }

}
