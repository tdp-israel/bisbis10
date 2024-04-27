package com.att.tdp.bisbis10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.entity.RestaurantRating;
import com.att.tdp.bisbis10.service.RestaurantRatingService;

@RestController
@RequestMapping("/ratings")
public class RestaurantRatingController {
    RestaurantRatingService restaurantRatingService;

    @Autowired
    public RestaurantRatingController(RestaurantRatingService restaurantRatingService) {
        this.restaurantRatingService = restaurantRatingService;
    }

    @PostMapping
    public void addRestaurantRating(@RequestBody RestaurantRating restaurantRating) {
        restaurantRatingService.addRestaurantRating(restaurantRating);
    }
}
