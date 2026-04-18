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
@Table(name = "restaurants")
@Schema(description = "Restaurant entity representing a food delivery restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the restaurant", example = "1")
    private Long id;

    @Schema(description = "Name of the restaurant", example = "Pizza Hut")
    private String name;

    @Schema(description = "Type of cuisine served", example = "Italian, Pizza")
    private String cuisine;

    @Schema(description = "Physical address of the restaurant", example = "123 Main St")
    private String address;

    @Schema(description = "Rating of the restaurant", example = "4.5")
    private Double rating;

    @Schema(description = "Delivery time in minutes", example = "30")
    private Integer deliveryTime;

    @Schema(description = "Delivery charge in rupees", example = "50")
    private Integer deliveryCharge;
}
