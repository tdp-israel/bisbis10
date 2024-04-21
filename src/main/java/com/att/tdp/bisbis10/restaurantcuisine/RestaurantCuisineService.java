package com.att.tdp.bisbis10.restaurantcuisine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantCuisineService {
    private final RestaurantCuisineRespository restaurantCuisineRespository;

    @Autowired
    public RestaurantCuisineService(RestaurantCuisineRespository restaurantCuisineRespository) {
        this.restaurantCuisineRespository = restaurantCuisineRespository;
    }

    public void addRestaurantCuisine(RestaurantCuisine restaurantCuisine) {
        this.restaurantCuisineRespository.save(restaurantCuisine);
    }

    public void deleteRestaurantCuisine(Long restaurantCuisineId) {
        this.restaurantCuisineRespository.deleteById(restaurantCuisineId);
    }
}