package models;

import lombok.Data;
import lombok.NonNull;

@Data
public class DishModel {
    @NonNull int id;
    @NonNull String title;
    @NonNull int totalCalory;

}
