package com.att.tdp.bisbis10.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.dto.RestaurantRequest;
import com.att.tdp.bisbis10.dto.RestaurantUpdateCuisinesRequest;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants(@RequestParam(required = false) String cuisine) {
        List<Restaurant> restaurants;
        if(cuisine != null) {
            restaurants = restaurantService.getRestaurantsByCuisine(cuisine);
        }
        else {
            restaurants = restaurantService.getRestaurants();
        }

        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Integer restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant addRestaurant(@RequestBody @Valid RestaurantRequest restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return newRestaurant;
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") Integer restaurantId, 
                                 @RequestBody @Valid RestaurantUpdateCuisinesRequest restaurantUpdateCuisinesRequest) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurantCuisines(restaurantId, restaurantUpdateCuisinesRequest);
        return updatedRestaurant;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable("id") Integer restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
