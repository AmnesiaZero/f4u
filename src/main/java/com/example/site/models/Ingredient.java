package com.example.site.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    int id;
    String text;
    int calory;
}

