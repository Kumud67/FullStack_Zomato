package com.zomato.clone.service;

import com.zomato.clone.model.Food;
import com.zomato.clone.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public List<Food> getFoodsByRestaurantId(Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Long id, Food food) {
        if (foodRepository.existsById(id)) {
            food.setId(id);
            return foodRepository.save(food);
        }
        return null;
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
