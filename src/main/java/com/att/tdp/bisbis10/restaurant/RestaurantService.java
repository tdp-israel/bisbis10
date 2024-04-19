package com.att.tdp.bisbis10.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
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

    }

    public void updateRestaurant(Long restaurantId, 
                                 List<String> cuisines) {
        
    }

    public void deleteRestaurant(Long restaurantId) {

    }
}
