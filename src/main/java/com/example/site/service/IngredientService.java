package com.example.site.service;

import com.example.site.models.Ingredient;
import com.example.site.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
}
