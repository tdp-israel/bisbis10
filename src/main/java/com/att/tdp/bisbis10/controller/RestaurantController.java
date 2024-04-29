package com.att.tdp.bisbis10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Restaurant>> getRestaurants(@RequestParam(required = false) String cuisine,
                                            @RequestParam(required = false) Integer page, 
                                            @RequestParam(required = false) Integer pageSize) {
        List<Restaurant> restaurants;

        if(cuisine != null) {
            restaurants = restaurantService.getRestaurantsByCuisine(cuisine, page, pageSize);
        }
        else {
            restaurants = restaurantService.getRestaurants(page, pageSize);
        }

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Integer restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody @Valid RestaurantRequest restaurant) {
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Integer restaurantId, 
                                 @RequestBody @Valid RestaurantUpdateCuisinesRequest restaurantUpdateCuisinesRequest) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurantCuisines(restaurantId, restaurantUpdateCuisinesRequest);
        return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Integer restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return ResponseEntity.noContent().build();
    }
}
