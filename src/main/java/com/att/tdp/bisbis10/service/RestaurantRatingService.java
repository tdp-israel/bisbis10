package com.att.tdp.bisbis10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.entity.RestaurantRating;
import com.att.tdp.bisbis10.repository.RestaurantRatingRepository;

@Service
public class RestaurantRatingService {
    RestaurantRatingRepository restaurantRatingRepository;
    RestaurantService restaurantService;

    @Autowired
    public RestaurantRatingService(RestaurantRatingRepository restaurantRatingRepository, RestaurantService restaurantService) {
        this.restaurantRatingRepository = restaurantRatingRepository;
        this.restaurantService = restaurantService;
    }

    public void addRestaurantRating(RestaurantRating restaurantRating) {
        Integer restaurantId = restaurantRating.getRestaurantId();
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        
        restaurantRating.setRestaurant(restaurant);
        restaurantRatingRepository.save(restaurantRating);
    }
}
