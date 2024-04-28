package com.att.tdp.bisbis10.exception.restaurant;

import com.att.tdp.bisbis10.exception.ItemNotFoundException;

public class RestaurantNotFoundException extends ItemNotFoundException {
    static String message = "No restaurant found with this id!";

    public RestaurantNotFoundException() {
        super(RestaurantNotFoundException.message);
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
