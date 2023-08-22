package com.example.f4u.controllers;

import com.example.f4u.models.DishPart;
import com.example.f4u.service.DishPartService;
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
        return dishPartService.getAllDishParts();
    }

}
