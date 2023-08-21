package com.example.site.repositories;

import com.example.site.models.DishPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishPartRepository extends JpaRepository<DishPart,Integer> {
    List<DishPart> findByDishId(int dishId);

    List<DishPart> findByIngredientId(int id);
}
