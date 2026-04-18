package com.zomato.clone.model;

import jakarta.persistence.Embeddable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Schema(description = "Order item entity representing a food item in an order")
public class OrderItem {
    @Schema(description = "ID of the food item", example = "1")
    private Long id;

    @Schema(description = "Name of the food item", example = "Margherita Pizza")
    private String name;

    @Schema(description = "Price of the food item in rupees", example = "299.0")
    private Double price;

    @Schema(description = "Quantity ordered", example = "2")
    private Integer quantity;
}
