package com.example.f4u.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "dish_part")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;
    @Column(name = "dish_id")
    private int dishId;
    @Column(name = "ingredient_id")
    private int ingredientId;
    @Column(name = "qty")
    private int qty;
    public DishPart(int dishId, int ingredientId, int qty) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.qty = qty;
    }




}
