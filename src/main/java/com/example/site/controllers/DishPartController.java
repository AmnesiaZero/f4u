package com.example.site.controllers;

import com.example.site.models.DishPart;
import com.example.site.service.DishPartService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/recipes")
public class DishPartController {
    @Autowired
    private DishPartService dishPartService;
    @GetMapping("/get-all-dish-parts")
    public List<DishPart> getAllDishParts(){
        return dishPartService.getRecipes();
    }

}
