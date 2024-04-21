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
}
