package com.example.f4u.exceptions;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(int id){
        super("Не могу найти ингридиент с id - "+id);
    }
    public IngredientNotFoundException(String string) {
        super(string);
    }
}
