package com.example.site.models;

import com.example.site.service.DishPartService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
@Table(name = "dish_part")
public class DishPart {
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
    @Transient
    int qtyCalory;

    public DishPart() {
    }
    public DishPart(int dishId, int ingredientId, int qty, int qtyCalory) {
        this.dishId = dishId;
        this.ingredientId = ingredientId;
        this.qty = qty;
        this.qtyCalory = qtyCalory;
    }


}
