package com.att.tdp.bisbis10.dish;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantService;

@Service
public class DishService {
    DishRepository dishRepository;
    RestaurantService restaurantService;

    @Autowired
    public DishService(DishRepository dishRepository, RestaurantService restaurantService) {
        this.dishRepository = dishRepository;
        this.restaurantService = restaurantService;
    }

    public void addDish(Long restaurantId, Dish dish) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        dish.setRestaurant(restaurant);
        dishRepository.save(dish);
    }

    public void deleteDish(Long restaurantId, Long dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        // TODO
        // Throw error if dish does not exist
        // Throw error if restaurantId does not match dish restaurant
        dishRepository.deleteById(dishId);
    }

}
