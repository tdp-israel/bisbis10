package com.att.tdp.bisbis10.exception.dish;

public class DishDoesNotBelongToRestaurantException extends RuntimeException {
    static String message1 = "The dish with id ";
    static String message2 = " does not belong to the restaurant with id ";

    public DishDoesNotBelongToRestaurantException(Integer dishId, Integer restaurantId) {
        super(
            message1 + dishId + 
            message2 + restaurantId
        );
    }

    public DishDoesNotBelongToRestaurantException(String message) {
        super(message);
    }

    public DishDoesNotBelongToRestaurantException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishDoesNotBelongToRestaurantException(Throwable cause) {
        super(cause);
    }
}
