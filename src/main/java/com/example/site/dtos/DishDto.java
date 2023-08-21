package com.example.site.dtos;

import jakarta.persistence.*;

public class DishDto {
    private Integer id;
    private String title;
    private int totalCalory;
    public DishDto(String title, int totalCalory) {
        this.title = title;
        this.totalCalory = totalCalory;
    }
}
