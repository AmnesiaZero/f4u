package com.example.site.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;
    @Column(name = "dish_id")
    int dishId;
    @Column(name = "ingredient_id")
    int ingredientId;
    @Column(name = "qty")
    int qty;
    @Column(name = "qty_calory")
    int qtyCalory;

    public Recipe() {
    }
    public Recipe(int dishId, int ingredientId, int qty, int qtyCalory) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.qty = qty;
        this.qtyCalory = qtyCalory;
    }
}
