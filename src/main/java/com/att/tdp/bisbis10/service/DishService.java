package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return restaurant.map(Restaurant::getDishes).orElse(null);
    }

    public Dish addDishToRestaurant(Long restaurantId, Dish dish) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            dish.setRestaurant(restaurant.get());
            return dishRepository.save(dish);
        }
        return null;
    }

    public Dish updateDish(Long dishId, Dish updatedDish) {
        if (dishRepository.existsById(dishId)) {
            updatedDish.setId(dishId);
            return dishRepository.save(updatedDish);
        }
        return null;
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}
