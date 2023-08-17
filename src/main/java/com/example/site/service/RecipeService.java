package com.example.site.service;

import com.example.site.models.Recipe;
import com.example.site.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> getRecipes(){
        return recipeRepository.findAll();
    }
}
