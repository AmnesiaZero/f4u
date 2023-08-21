package com.example.site.exceptions;

public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException(int id){
        super("Не могу найти блюдо с id - "+id);
    }
    public DishNotFoundException(String string) {
        super(string);
    }
}
