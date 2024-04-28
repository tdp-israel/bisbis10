package com.att.tdp.bisbis10.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.RestaurantRequest;
import com.att.tdp.bisbis10.dto.RestaurantUpdateCuisinesRequest;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;


@Service
public class RestaurantService {
    private Integer DEFAULT_PAGE_SIZE;

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.DEFAULT_PAGE_SIZE = 20;
    }


    public List<Restaurant> getRestaurants(Integer page, Integer pageSize) {
        List<Restaurant> restaurants;
        
        if(page != null || pageSize != null) {
            Pageable pageable = PageRequest.of(
                page == null ? 0 : page, 
                pageSize == null ? DEFAULT_PAGE_SIZE : pageSize
            );

            Page<Restaurant> restaurantsPage = restaurantRepository.findAll(
                pageable
            );

            restaurants = restaurantsPage.getContent();
        }
        else {
            restaurants = restaurantRepository.findAll();
        }

        return restaurants;
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine, Integer page, Integer pageSize) {
        List<Restaurant> restaurants;
        
        if(page != null || pageSize != null) {
            Pageable pageable = PageRequest.of(
                page == null ? 0 : page, 
                pageSize == null ? DEFAULT_PAGE_SIZE : pageSize
            );

            Page<Restaurant> restaurantsPage = restaurantRepository.findByCuisinesContaining(
                cuisine, pageable
            );

            restaurants = restaurantsPage.getContent();
        }
        else {
            restaurants = restaurantRepository.findByCuisinesContaining(cuisine);
        }
        
        return restaurants;
    }


    public Page<Restaurant> getRestaurantsByCuisine(String cuisine, int page, int pageSize) {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Restaurant> restaurantsPage = restaurantRepository.findByCuisinesContaining(
            cuisine, pageable
        );
        return restaurantsPage;
    }
    
    public Restaurant getRestaurantById(Integer restaurantId) {
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

        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public Restaurant updateRestaurantCuisines(Integer restaurantId, 
                                 RestaurantUpdateCuisinesRequest restaurantUpdateCuisinesRequest) {
        List<String> cuisines = restaurantUpdateCuisinesRequest.getCuisines();
        Restaurant restaurant;

        Optional<Restaurant> restaurantExists = restaurantRepository.findById(restaurantId);

        // TODO
        // Throw Error if restaurant does not exist!

        restaurant = restaurantExists.get();
        restaurant.setCuisines(cuisines);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Integer restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        // TODO
        // Throw error if Restaurant does not exist
        
        restaurantRepository.deleteById(restaurantId);
    }
}
