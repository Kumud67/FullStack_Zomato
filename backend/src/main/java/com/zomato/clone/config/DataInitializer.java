package com.zomato.clone.config;

import com.zomato.clone.model.Restaurant;
import com.zomato.clone.model.Food;
import com.zomato.clone.repository.RestaurantRepository;
import com.zomato.clone.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample restaurants
        Restaurant pizza = new Restaurant(null, "Pizza Hut", "Italian, Pizza", "123 Main St", 4.5, 30, 50);
        Restaurant burger = new Restaurant(null, "Burger King", "Fast Food, Burgers", "456 Oak Ave", 4.2, 25, 40);
        Restaurant chinese = new Restaurant(null, "Chow Chow", "Chinese, Asian", "789 Pine Rd", 4.7, 35, 60);
        Restaurant south = new Restaurant(null, "South Indian Kitchen", "South Indian, Dosa", "321 Elm St", 4.6, 20, 30);

        restaurantRepository.save(pizza);
        restaurantRepository.save(burger);
        restaurantRepository.save(chinese);
        restaurantRepository.save(south);

        // Create sample foods for Pizza Hut
        foodRepository.save(new Food(null, 1L, "Margherita Pizza", "Fresh mozzarella, basil, tomato sauce", 299.0, "Pizza"));
        foodRepository.save(new Food(null, 1L, "Pepperoni Pizza", "Pepperoni, mozzarella, tomato sauce", 349.0, "Pizza"));
        foodRepository.save(new Food(null, 1L, "Garlic Bread", "Crispy garlic bread with butter", 99.0, "Sides"));
        foodRepository.save(new Food(null, 1L, "Coke", "Cold carbonated beverage", 49.0, "Drinks"));

        // Create sample foods for Burger King
        foodRepository.save(new Food(null, 2L, "Whopper Burger", "flame-grilled beef patty with toppings", 249.0, "Burger"));
        foodRepository.save(new Food(null, 2L, "Chicken Burger", "Crispy fried chicken patty", 199.0, "Burger"));
        foodRepository.save(new Food(null, 2L, "French Fries", "Crispy golden fries", 79.0, "Sides"));
        foodRepository.save(new Food(null, 2L, "Ice Cream Cone", "Vanilla ice cream cone", 69.0, "Dessert"));

        // Create sample foods for Chow Chow
        foodRepository.save(new Food(null, 3L, "Hakka Noodles", "Stir-fried noodles with vegetables", 199.0, "Noodles"));
        foodRepository.save(new Food(null, 3L, "Fried Rice", "Basmati rice with vegetables and sauce", 179.0, "Rice"));
        foodRepository.save(new Food(null, 3L, "Manchurian", "Crispy balls with tangy sauce", 219.0, "Appetizer"));
        foodRepository.save(new Food(null, 3L, "Spring Roll", "Crispy spring rolls with sauce", 129.0, "Appetizer"));

        // Create sample foods for South Indian Kitchen
        foodRepository.save(new Food(null, 4L, "Masala Dosa", "Crispy dosa with potato filling", 149.0, "Dosa"));
        foodRepository.save(new Food(null, 4L, "Butter Dosa", "Crispy dosa with butter", 129.0, "Dosa"));
        foodRepository.save(new Food(null, 4L, "Sambar", "South Indian lentil soup", 59.0, "Soup"));
        foodRepository.save(new Food(null, 4L, "Idli", "Steamed rice cakes", 89.0, "Breakfast"));

        System.out.println("Sample data initialized successfully!");
    }
}
