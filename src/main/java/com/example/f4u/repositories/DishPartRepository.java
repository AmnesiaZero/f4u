package com.example.f4u.repositories;

import com.example.f4u.models.DishPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishPartRepository extends JpaRepository<DishPart,Integer> {
    List<DishPart> findByDishId(int dishId);

    List<DishPart> findByIngredientId(int id);
}
