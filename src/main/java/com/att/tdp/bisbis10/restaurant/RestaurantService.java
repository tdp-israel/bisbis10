package com.att.tdp.bisbis10.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        return new ArrayList<Restaurant>();
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return new ArrayList<Restaurant>();
    }
    
    public Restaurant getRestaurantById(Long restaurantId) {
        return new Restaurant();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Long restaurantId, 
                                 List<String> cuisines) {
        
    }

    public void deleteRestaurant(Long restaurantId) {

    }
}
