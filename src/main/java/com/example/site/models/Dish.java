package com.example.site.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Dish {
    @NonNull int id;
    @NonNull  String title;
    @NonNull int totalCalory;
}
