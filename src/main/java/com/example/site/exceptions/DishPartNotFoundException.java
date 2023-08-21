package com.example.site.exceptions;

public class DishPartNotFoundException extends RuntimeException{
    public DishPartNotFoundException(int id){
        super("Не могу найти dishPart с id - "+id);
    }
    public DishPartNotFoundException(String string) {
        super(string);
    }
}
