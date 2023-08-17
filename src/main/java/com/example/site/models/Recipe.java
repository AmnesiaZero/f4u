package com.example.site.models;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

@Data
@AllArgsConstructor
public class Recipe {
    int id;
    @ManyToOne
    int dishId;
    int ingredientId;
    int quantity;
    int quantityCalory;
}
