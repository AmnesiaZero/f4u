package models;

import lombok.Data;

@Data
public class RecipeModel {
    int id;
    int dishId;
    int ingredientId;
    int quantity;
    int quantityCalory;
}
