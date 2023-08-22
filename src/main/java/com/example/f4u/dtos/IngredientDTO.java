package com.example.f4u.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
    private Integer id;
    private String name;
    private int calory;
    public IngredientDTO(String name, int calory) {
        this.name = name;
        this.calory = calory;
    }
    public IngredientDTO(String name){
        this.name = name;
    }


}
