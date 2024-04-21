package com.att.tdp.bisbis10.restaurantrating;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantService;

@Service
public class RestaurantRatingService {
    RestaurantRatingRepository restaurantRatingRepository;
    RestaurantService restaurantService;

    @Autowired
    public RestaurantRatingService(RestaurantRatingRepository restaurantRatingRepository, RestaurantService restaurantService) {
        this.restaurantRatingRepository = restaurantRatingRepository;
        this.restaurantService = restaurantService;
    }

    public void addRestaurantRating(RestaurantRatingCreateRequest restaurantRatingCreateRequest) {
        Long restaurantId = restaurantRatingCreateRequest.getRestaurantId();
        float rating = restaurantRatingCreateRequest.getRating();

        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        RestaurantRating restaurantRating = new RestaurantRating(rating, restaurant);
        restaurantRatingRepository.save(restaurantRating);
    }
}
