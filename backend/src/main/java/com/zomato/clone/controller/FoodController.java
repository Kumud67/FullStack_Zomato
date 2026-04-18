package com.zomato.clone.controller;

import com.zomato.clone.model.Food;
import com.zomato.clone.service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
@Tag(name = "Foods", description = "API endpoints for managing foods and menu items")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping
    @Operation(summary = "Get all foods", description = "Retrieve a list of all available food items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of foods"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/restaurant/{restaurantId}")
    @Operation(summary = "Get foods by restaurant", description = "Retrieve all food items for a specific restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved foods for restaurant"),
            @ApiResponse(responseCode = "404", description = "Restaurant not found")
    })
    public ResponseEntity<List<Food>> getFoodsByRestaurantId(@PathVariable Long restaurantId) {
        List<Food> foods = foodService.getFoodsByRestaurantId(restaurantId);
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get food by ID", description = "Retrieve a specific food item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food found"),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        Optional<Food> food = foodService.getFoodById(id);
        return food.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    @Operation(summary = "Create a new food item", description = "Add a new food item to the menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Food item created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a food item", description = "Update an existing food item's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Food item updated successfully"),
            @ApiResponse(responseCode = "404", description = "Food item not found")
    })
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFood(id, food);
        if (updatedFood != null) {
            return ResponseEntity.ok(updatedFood);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a food item", description = "Remove a food item from the menu")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Food item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Food item not found")
    })
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
