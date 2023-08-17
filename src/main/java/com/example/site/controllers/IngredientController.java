package com.example.site.controllers;

import com.example.site.service.IngredientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("api/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

}
