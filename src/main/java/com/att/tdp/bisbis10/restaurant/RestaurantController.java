package com.att.tdp.bisbis10.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    
    @GetMapping
    public List<Restaurant> getRestaurants() {
        return new ArrayList<Restaurant>();
    }

    @GetMapping
    public List<Restaurant> getRestaurantsByCuisine(@RequestParam("queryParam") String cuisine) {
        return new ArrayList<Restaurant>();
    }

    @GetMapping("/{id}")
    public List<Restaurant> getRestaurant(@PathVariable("id") Long restaurantId) {
        return new ArrayList<Restaurant>();
    }

    @PostMapping
    public void addRestaurant(Restaurant restaurant) {

    }

    @GetMapping("/{id}")
    public void updateRestaurant(@PathVariable("id") Long restaurantId, 
                                 @RequestBody List<String> cuisines) {
        
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long restaurantId) {

    }
}
