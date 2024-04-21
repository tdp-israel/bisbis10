package com.att.tdp.bisbis10.restaurantrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RestaurantRatingController {
    RestaurantRatingService restaurantRatingService;

    @Autowired
    public RestaurantRatingController(RestaurantRatingService restaurantRatingService) {
        this.restaurantRatingService = restaurantRatingService;
    }

    @PostMapping
    public void addRestaurantRating(@RequestBody RestaurantRatingCreateRequest restaurantRatingCreateRequest) {
        restaurantRatingService.addRestaurantRating(restaurantRatingCreateRequest);
    }
}
