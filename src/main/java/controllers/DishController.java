package controllers;

import lombok.Data;
import models.DishModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping(path = "api/v1/dish")
public class DishController {
    @GetMapping
    public List<DishModel> getDish(){
        return List.of(new DishModel(1,"курага",5));
    }
}
