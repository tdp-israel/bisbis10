package com.att.tdp.bisbis10.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.RestaurantRequest;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.entity.RestaurantCuisine;
import com.att.tdp.bisbis10.repository.RestaurantRepository;


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

    public Restaurant addRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant(
            restaurantRequest.getName(),
            restaurantRequest.getIsKosher(),
            restaurantRequest.getCuisines()
        );

        List<RestaurantCuisine> restaurantCuisines = new ArrayList<>();
        for (String cuisine : restaurant.getCuisines()) {
            restaurantCuisines.add(new RestaurantCuisine(cuisine, restaurant));
        }
        restaurant.setCuisines_(restaurantCuisines);

        restaurantRepository.save(restaurant);
        restaurant.getCuisines_().forEach(cuisine -> restaurantCuisineService.addRestaurantCuisine(cuisine));
    
        return restaurant;
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
