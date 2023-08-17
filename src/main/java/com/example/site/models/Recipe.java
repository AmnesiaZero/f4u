package com.example.site.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {
    int id;
    int dishId;
    int ingredientId;
    int quantity;
    int quantityCalory;
}
