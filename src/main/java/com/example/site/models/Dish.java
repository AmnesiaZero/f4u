package com.example.site.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "total_calory")
    private int totalCalory;

    public Dish() {
    }

    public Dish(String title, int totalCalory) {
        this.title = title;
        this.totalCalory = totalCalory;
    }
}
