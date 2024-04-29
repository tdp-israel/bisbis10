package com.att.tdp.bisbis10.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.RestaurantRequest;
import com.att.tdp.bisbis10.dto.RestaurantUpdateCuisinesRequest;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.exception.restaurant.RestaurantNotFoundException;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.util.PaginationUtils;


@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    public List<Restaurant> getRestaurants(Integer page, Integer pageSize) {
        List<Restaurant> restaurants;
        
        if(page != null || pageSize != null) {
            Pageable pageable = PaginationUtils.createPageable(page, pageSize);
            
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
            Pageable pageable = PaginationUtils.createPageable(page, pageSize);

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
        
        if(!restaurant.isPresent()) {
            throw new RestaurantNotFoundException(restaurantId);
        }

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
        Set<String> cuisines = restaurantUpdateCuisinesRequest.getCuisines();
        Restaurant restaurant;

        Optional<Restaurant> restaurantExists = restaurantRepository.findById(restaurantId);

        if(!restaurantExists.isPresent()) {
            throw new RestaurantNotFoundException(restaurantId);
        }

        restaurant = restaurantExists.get();
        restaurant.setCuisines(cuisines);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public void deleteRestaurant(Integer restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        if(!restaurant.isPresent()) {
            throw new RestaurantNotFoundException(restaurantId);
        }
        
        restaurantRepository.deleteById(restaurantId);
    }
}
