package com.example.site.service;

import com.example.site.exceptions.IngredientNotFoundException;
import com.example.site.models.Ingredient;
import com.example.site.repositories.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }
    public Ingredient findIngredientById(int id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isEmpty())
            throw new IngredientNotFoundException(id);
        return ingredient.get();
    }
    public List<Integer> getIngredientsId(List<Ingredient> ingredients){
        List<Integer> ingredientsIds = new ArrayList<>();
        for (Ingredient ingredient:ingredients){
            ingredientsIds.add(ingredient.getId());
        }
        return ingredientsIds;
    }
}
