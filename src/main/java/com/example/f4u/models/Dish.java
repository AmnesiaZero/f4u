package com.example.f4u.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;

@Data
@AllArgsConstructor
@Entity
@Table(name = "dish")
@NoArgsConstructor
@Builder
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false)
    private Integer id;

    @Column(name = "title")
    private String title;


    public Dish(String title){
        this.title = title;
    }
}
