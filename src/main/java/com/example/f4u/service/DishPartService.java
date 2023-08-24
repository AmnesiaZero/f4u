package com.example.f4u.service;

import com.example.f4u.exceptions.DishPartNotFoundException;
import com.example.f4u.models.Ingredient;
import com.example.f4u.models.DishPart;
import com.example.f4u.repositories.DishPartRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Log4j
@Service
public class DishPartService {
    @Autowired
    private DishPartRepository dishPartRepository;
    @Autowired
    private IngredientService ingredientService;
    public List<DishPart> getAllDishParts(){
        return dishPartRepository.findAll();
    }
    public DishPart findDishPartById(int dishPartId){
        Optional<DishPart> recipe = dishPartRepository.findById(dishPartId);
        if(recipe.isEmpty())
            throw new DishPartNotFoundException(dishPartId);
        return recipe.get();
    }
    public int findIngredientId(int dishPartId){
        DishPart dishPart = findDishPartById(dishPartId);
        return dishPart.getIngredientId();
    }
    public int findQty(int dishPartId){
        DishPart dishPart = findDishPartById(dishPartId);
        return dishPart.getQty();
    }
    public int findQtyCalory(int dishPartId){
        Ingredient ingredient = ingredientService.findIngredientById(findIngredientId(dishPartId));
        int ingredientCalory = ingredient.getCalory();
        int qty = findQty(dishPartId);
        return ingredientCalory * qty;
    }
    public List<DishPart> findDishPartsByDishId(int dishId){
        Optional<List<DishPart>> dishParts = dishPartRepository.findByDishId(dishId);
        if (dishParts.isEmpty())
            throw new DishPartNotFoundException("Не найдены dishPart с dishId = " + dishId);
        return dishParts.get();
    }



}
