package com.example.f4u.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    private Integer id;
    int dishId;
    int ingredientId;
    int qty;
    int qtyCalory;
    public RecipeDto(int dishId, int ingredientId, int qty, int qtyCalory) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.qty = qty;
        this.qtyCalory = qtyCalory;
    }

}