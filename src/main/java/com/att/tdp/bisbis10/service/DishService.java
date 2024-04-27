package com.att.tdp.bisbis10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;

@Service
public class DishService {
    DishRepository dishRepository;
    RestaurantService restaurantService;

    @Autowired
    public DishService(DishRepository dishRepository, RestaurantService restaurantService) {
        this.dishRepository = dishRepository;
        this.restaurantService = restaurantService;
    }

    public List<Dish> getDishesByRestaurantId(Integer restaurantId) {
        List<Dish> dishes = dishRepository.getDishesByRestaurantId(restaurantId);
        return dishes; 
    }

    public void addDish(Integer restaurantId, Dish dish) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        dish.setRestaurant(restaurant);
        dishRepository.save(dish);
    }

    public void deleteDish(Integer restaurantId, Integer dishId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        // TODO
        // Throw error if dish does not exist
        // Throw error if restaurantId does not match dish restaurant
        dishRepository.deleteById(dishId);
    }

}
