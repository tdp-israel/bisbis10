package com.att.tdp.bisbis10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.RestaurantRatingRequest;
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

    public void addRestaurantRating(RestaurantRatingRequest restaurantRatingRequest) {
        Integer restaurantId = restaurantRatingRequest.getRestaurantId();
        Float rating = restaurantRatingRequest.getRating();

        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        
        RestaurantRating restaurantRating = new RestaurantRating(rating, restaurant);
        restaurantRatingRepository.save(restaurantRating);
    }
}
