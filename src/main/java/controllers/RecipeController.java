package controllers;

import lombok.Data;
import models.RecipeModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("api/v1/recipe")
public class RecipeController {
//    public List<RecipeModel> getRecipe(){
//        return List.of(new RecipeModel(1,))
//    }

}
