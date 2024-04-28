package com.att.tdp.bisbis10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.dto.RestaurantRatingRequest;
import com.att.tdp.bisbis10.service.RestaurantRatingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ratings")
public class RestaurantRatingController {
    RestaurantRatingService restaurantRatingService;

    @Autowired
    public RestaurantRatingController(RestaurantRatingService restaurantRatingService) {
        this.restaurantRatingService = restaurantRatingService;
    }

    @PostMapping
    public void addRestaurantRating(@Valid @RequestBody RestaurantRatingRequest restaurantRatingRequest) {
        restaurantRatingService.addRestaurantRating(restaurantRatingRequest);
    }
}
