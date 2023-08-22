package com.example.f4u.service;

import com.example.f4u.dtos.DishDTO;
import com.example.f4u.dtos.IngredientDTO;
import com.example.f4u.exceptions.DishNotFoundException;
import com.example.f4u.models.Dish;
import com.example.f4u.models.DishPart;
import com.example.f4u.repositories.DishRepository;
import lombok.Builder;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Log4j
@Service
@Builder
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
    public List<DishDTO> getDishesByIngredients(List<IngredientDTO> ingredients){
        List<Integer> ingredientsId = ingredientService.getIngredientsId(ingredients);
        return findDishesByIngredientsIds(ingredientsId);
    }
    public Dish toDish(DishDTO dishDTO){
        return Dish.builder().
                id(dishDTO.getId()).
                title(dishDTO.getTitle()).
                totalCalory(dishDTO.getTotalCalory()).
                build();
    }
    public DishDTO toDTO(Dish dish){
        return DishDTO.builder().
                id(dish.getId()).
                title(dish.getTitle()).
                totalCalory(dish.getTotalCalory()).
                build();
    }

    public Dish findDishById(int dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        if(dish.isEmpty())
            throw new DishNotFoundException(dishId);
        return dish.get();
    }
    public List<DishDTO> findDishesByIngredientsIds(List<Integer> ingredientsIds){
        List<Dish> finalDishes = new ArrayList<>();
        List<Dish> allDishes = getDishes();
        log.debug(allDishes);
        for(Dish dish:allDishes) {
            log.debug("Dish - " + dish);
            List<DishPart> dishParts = dishPartService.findDishPartsByDishId(dish.getId());
            log.debug(dishParts);
            List<Integer> ingredientsIdsCopy = new ArrayList<>(ingredientsIds);
            log.debug(ingredientsIdsCopy);
            boolean flag = false;
            for(DishPart dishPart:dishParts){
                for(int ingredientId:ingredientsIdsCopy){//проходимся по всем полученным ингридиентам
                    if(dishPart.getIngredientId()==ingredientId)//если в нашем блюде есть нужный ингридиент -
                          ingredientsIdsCopy.remove(ingredientId);// убираем его из списка
                    if(ingredientsIdsCopy.isEmpty()){
                        log.debug("Найдено до конца цикла");
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    log.debug("Вышел из цикла,поскольку блюдо уже подходит");
                    break;
                }
            }
            if(ingredientsIdsCopy.isEmpty()){
                log.info("Найдено нужное блюдо - " + dish);
                finalDishes.add(dish);
            }
            else
                log.info("Блюдо" + dish + "не подходит");
        }
        if(finalDishes.isEmpty()){
            log.info("Нужные блюда не были найдены");
            throw new DishNotFoundException("Нужные блюда не были найдены");
        }
        List<DishDTO> dishDTOS = new ArrayList<>();
        for (Dish dish:finalDishes)
            dishDTOS.add(toDTO(dish));
        return dishDTOS;
    }

//    public List<Dish> getDishesByIngredients(){
//
//
//    }

}
