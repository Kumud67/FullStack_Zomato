package com.zomato.clone.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "foods")
@Schema(description = "Food item entity representing a menu item")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the food item", example = "1")
    private Long id;

    @Schema(description = "ID of the restaurant that serves this food", example = "1")
    private Long restaurantId;

    @Schema(description = "Name of the food item", example = "Margherita Pizza")
    private String name;

    @Schema(description = "Description of the food item", example = "Fresh mozzarella, basil, tomato sauce")
    private String description;

    @Schema(description = "Price of the food item in rupees", example = "299.0")
    private Double price;

    @Schema(description = "Category of the food item", example = "Pizza")
    private String category;
}
