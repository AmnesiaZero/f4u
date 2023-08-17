package com.example.site.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
@Table
@AllArgsConstructor
public class Dish {
    @Id
    private int id;
    private String title;
    private int totalCalory;
}
