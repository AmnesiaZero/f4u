package com.example.f4u.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "calory")
    int calory;

    public Ingredient(String name, int calory) {
        this.name = name;
        this.calory = calory;
    }
    public Ingredient(){

    }
}

