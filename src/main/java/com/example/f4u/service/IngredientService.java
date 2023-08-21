package com.example.f4u.service;

import com.example.f4u.exceptions.IngredientNotFoundException;
import com.example.f4u.models.Ingredient;
import com.example.f4u.repositories.IngredientRepository;
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
