package com.example.f4u.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DishPartDTO {
    private Integer id;
    private int dishId;
    private int ingredientId;
    private int qty;
    private int qtyCalory;
    public DishPartDTO(int dishId, int ingredientId, int qty, int qtyCalory) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.qty = qty;
        this.qtyCalory = qtyCalory;
    }

}
