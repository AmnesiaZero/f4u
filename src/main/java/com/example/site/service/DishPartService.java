package com.example.site.service;

import com.example.site.exceptions.DishNotFoundException;
import com.example.site.exceptions.DishPartNotFoundException;
import com.example.site.models.Dish;
import com.example.site.models.Ingredient;
import com.example.site.models.DishPart;
import com.example.site.repositories.DishPartRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Log4j
@Service
public class DishPartService {
    @Autowired
    private DishPartRepository dishPartRepository;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private DishService dishService;
    public List<DishPart> getRecipes(){
        return dishPartRepository.findAll();
    }
    public DishPart findRecipeById(int recipeId){
        Optional<DishPart> recipe = dishPartRepository.findById(recipeId);
        if(recipe.isEmpty())
            throw new DishPartNotFoundException(recipeId);
        return recipe.get();
    }
    public int findIngredientId(int recipeId){
        DishPart dishPart = findRecipeById(recipeId);
        return dishPart.getIngredientId();
    }
    public int findQty(int recipeId){
        DishPart dishPart = findRecipeById(recipeId);
        return dishPart.getQty();
    }
    public int findQtyCalory(int recipeId){
        Ingredient ingredient = ingredientService.findIngredientById(findIngredientId(recipeId));
        int ingredientCalory = ingredient.getCalory();
        int qty = findQty(recipeId);
        return ingredientCalory * qty;
    }
    public List<DishPart> findDishPartsByDishId(int dishId){
        List<DishPart> dishParts = dishPartRepository.findByDishId(dishId);
        if (dishParts.isEmpty())
            throw new DishPartNotFoundException("Не найдены dishPart с dishId = " + dishId);
        return dishPartRepository.findByDishId(dishId);
    }



}
