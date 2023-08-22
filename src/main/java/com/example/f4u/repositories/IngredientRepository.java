package com.example.f4u.repositories;

import com.example.f4u.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
    Optional<Ingredient> findByName(String name);
}
