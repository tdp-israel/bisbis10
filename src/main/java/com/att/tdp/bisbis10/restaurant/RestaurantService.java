package com.att.tdp.bisbis10.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        List<Restaurant> restaurants = restaurantRepository.findRestaurantsByCausine(cuisine);
        return restaurants;
    }
    
    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        // TODO
        // Throw Error if restaurant does not exist!
        return restaurant.get();
    }

    public void addRestaurant(Restaurant restaurant) {
        System.out.println(restaurant);
        List<RestaurantCuisine> restaurantCuisines = new ArrayList<>();
        for (String cuisine : restaurant.getCuisines()) {
            restaurantCuisines.add(new RestaurantCuisine(cuisine, restaurant));
        }
        restaurant.setCuisines_(restaurantCuisines);
        restaurantRepository.save(restaurant);
        restaurant.getCuisines_().forEach(cuisine -> restaurantCuisineService.addRestaurantCuisine(cuisine));
    }

    public void updateRestaurantCuisines(Long restaurantId, 
                                 List<String> cuisines) {
        Optional<Restaurant> restaurantExists = restaurantRepository.findById(restaurantId);
        // TODO
        // Throw Error if restaurant does not exist!
        Restaurant restaurant = restaurantExists.get();
        restaurant.getCuisines_().forEach(cuisine -> restaurantCuisineService.deleteRestaurantCuisine(cuisine.getId()));
        cuisines.forEach(cuisine -> restaurantCuisineService.addRestaurantCuisine(new RestaurantCuisine(cuisine, restaurant)));
    }

    public void deleteRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        // TODO
        // Throw error if Restaurant does not exist
        restaurant.get().getCuisines_().forEach(cuisine -> restaurantCuisineService.deleteRestaurantCuisine(cuisine.getId()));
        restaurantRepository.deleteById(restaurantId);
    }
}
