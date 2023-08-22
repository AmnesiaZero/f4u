package com.example.f4u.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "calory")
    private int calory;
    public Ingredient(String name, int calory) {
        this.name = name;
        this.calory = calory;
    }
    public Ingredient(String name){
        this.name = name;
    }
}

