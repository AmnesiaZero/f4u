package com.example.f4u.service;

import com.example.f4u.dtos.IngredientDTO;
import com.example.f4u.exceptions.IngredientNotFoundException;
import com.example.f4u.models.Dish;
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
    public Ingredient toIngredient(IngredientDTO ingredientDTO){
        return Ingredient.builder().
                id(ingredientDTO.getId()).
                name(ingredientDTO.getName()).
                calory(ingredientDTO.getCalory()).
                build();
    }
    public IngredientDTO toDTO(Ingredient ingredient){
        return IngredientDTO.builder().
                id(ingredient.getId()).
                name(ingredient.getName()).
                calory(ingredient.getCalory()).
                build();
    }
    public List<IngredientDTO> getIngredients(){
       List<Ingredient> ingredients = ingredientRepository.findAll();
       return toDtoList(ingredients);
    }
    public List<IngredientDTO> toDtoList(List<Ingredient> ingredients){
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        for (Ingredient ingredient:ingredients)
            ingredientDTOS.add(toDTO(ingredient));
        return ingredientDTOS;
    }
    public List<Ingredient> toIngredientLis(List<IngredientDTO> ingredientDTOS){
        List<Ingredient> ingredients = new ArrayList<>();
        for (IngredientDTO ingredientDTO:ingredientDTOS)
            ingredients.add(toIngredient(ingredientDTO));
        return ingredients;
    }
    public Ingredient findIngredientById(int id){
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isEmpty())
            throw new IngredientNotFoundException(id);
        return ingredient.get();
    }
    public Ingredient findIngredientByName(String name){
        Optional<Ingredient> ingredient = ingredientRepository.findByName(name);
        if(ingredient.isEmpty())
            throw new IngredientNotFoundException("Не надйен ингридиент,имя - " + name);
        return ingredient.get();
    }
    public List<Integer> getIngredientsId(List<IngredientDTO> ingredients){
        List<Integer> ingredientsIds = new ArrayList<>();
        for (IngredientDTO receivedIngredient:ingredients){
            String name = receivedIngredient.getName();
            Ingredient tableIngredient = findIngredientByName(name);
            ingredientsIds.add(tableIngredient.getId());
        }
        return ingredientsIds;
    }
}
