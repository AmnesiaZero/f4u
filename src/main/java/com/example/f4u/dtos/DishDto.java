package com.example.f4u.dtos;

public class DishDto {
    private Integer id;
    private String title;
    private int totalCalory;
    public DishDto(String title, int totalCalory) {
        this.title = title;
        this.totalCalory = totalCalory;
    }
}
