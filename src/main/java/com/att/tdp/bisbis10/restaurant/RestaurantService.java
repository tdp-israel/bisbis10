package com.att.tdp.bisbis10.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.restaurantcuisine.RestaurantCuisine;
import com.att.tdp.bisbis10.restaurantcuisine.RestaurantCuisineService;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantCuisineService restaurantCuisineService;


    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantCuisineService restaurantCuisineService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantCuisineService = restaurantCuisineService;
    }


    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        System.out.println(cuisine);
        // List<Restaurant> restaurants = restaurantRepository.findRestaurantsByCausine(cuisine);
        return new ArrayList<>();
    }
    
    public Restaurant getRestaurantById(Long restaurantId) {
        return new Restaurant();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        System.out.println(restaurant);
        // for (String cuisine : restaurant.getCuisines()) {
        //     System.out.println(cuisine);
        //     RestaurantCuisine restaurantCuisine = new RestaurantCuisine(restaurant.getId(), cuisine);
        //     restaurantCuisineService.addRestaurantCuisine(restaurantCuisine);
        // }
    }

    public void updateRestaurant(Long restaurantId, 
                                 List<String> cuisines) {
        
    }

    public void deleteRestaurant(Long restaurantId) {

    }
}
