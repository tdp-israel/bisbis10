package com.att.tdp.bisbis10.restaurant;

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
    public Restaurant getRestaurant(@PathVariable("id") Long restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    // TODO
    @PutMapping("/{id}")
    public void updateRestaurant(@PathVariable("id") Long restaurantId, 
                                 @RequestBody Map<String, List<String>> requestBody) {
        List<String> cuisines = requestBody.get("cuisines");
    }

    // TODO
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable("id") Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }
}
