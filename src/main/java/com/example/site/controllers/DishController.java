package com.example.site.controllers;

import com.example.site.service.DishService;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.site.models.Dish;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;
    @GetMapping("/get")
    public List<Dish> getDish(){
        return dishService.getDish();
    }
}
