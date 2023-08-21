package com.example.f4u.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Transient
    private int totalCalory;

    public Dish(String title, int totalCalory) {
        this.title = title;
        this.totalCalory = totalCalory;
    }
    public Dish(String title){
        this.title = title;
    }
}
