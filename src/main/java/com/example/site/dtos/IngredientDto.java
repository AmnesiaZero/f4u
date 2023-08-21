package com.example.site.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private Integer id;
    String name;
    int calory;
    public IngredientDto(String name, int calory) {
        this.name = name;
        this.calory = calory;
    }

}