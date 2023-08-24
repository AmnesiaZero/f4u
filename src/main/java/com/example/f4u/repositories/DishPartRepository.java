package com.example.f4u.repositories;

import com.example.f4u.models.DishPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishPartRepository extends JpaRepository<DishPart,Integer> {
    Optional<List<DishPart>> findByDishId(int dishId);

    List<DishPart> findByIngredientId(int id);
}
