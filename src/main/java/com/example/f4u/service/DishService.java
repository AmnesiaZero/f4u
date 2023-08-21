package com.example.f4u.service;

import com.example.f4u.exceptions.DishNotFoundException;
import com.example.f4u.models.Dish;
import com.example.f4u.models.DishPart;
import com.example.f4u.models.Ingredient;
import com.example.f4u.repositories.DishRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Log4j
@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private DishPartService dishPartService;
    public List<Dish> getDishes(){
        return dishRepository.findAll();
    }
    //Надо
    //1. Получить id полученных ингридиентов
    //2. Получить все DishPart,с одинаковым dishId и совпадающим с id полученных ингридиентов
    public List<Dish> getDishesByIngredients(List<Ingredient> ingredients) {
        List<Integer> ingredientsId = ingredientService.getIngredientsId(ingredients);
        return findDishesByIngredientsIds(ingredientsId);
    }

    public Dish findDishById(int dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        if(dish.isEmpty())
            throw new DishNotFoundException(dishId);
        return dish.get();
    }
    public List<Dish> findDishesByIngredientsIds(List<Integer> ingredientsIds){
        List<Dish> finalDishes = new ArrayList<>();
        List<Dish> allDishes = getDishes();
        for(Dish dish:allDishes) {
            int dishId = dish.getId();
            List<DishPart> dishParts = dishPartService.findDishPartsByDishId(dishId);
            for(DishPart dishPart:dishParts){
                for(int id:ingredientsIds){
                    if(dishPart.getIngredientId()==id)
                        ingredientsIds.remove(id);
                }
            }
            if(ingredientsIds.isEmpty()){
                log.info("Найдено нужное блюдо - " + dish);
                finalDishes.add(dish);
            }
        }
        if(finalDishes.isEmpty()){
            log.info("Нужные блюда не были найдены");
            throw new DishNotFoundException("Нужные блюда не были найдены");
        }
        else
            return finalDishes;
    }
//    public List<Dish> getDishesByIngredients(){
//
//
//    }

}
