package com.att.tdp.bisbis10.exception.restaurant;

import com.att.tdp.bisbis10.exception.ItemNotFoundException;

public class RestaurantNotFoundException extends ItemNotFoundException {
    static String message = "No restaurant found with id ";

    public RestaurantNotFoundException(Integer restaurantId) {
        super(RestaurantNotFoundException.message + restaurantId);
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }

    public RestaurantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurantNotFoundException(Throwable cause) {
        super(RestaurantNotFoundException.message, cause);
    }
}
