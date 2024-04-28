package com.att.tdp.bisbis10.exception.dish;

public class DishDoesNotBelongToRestaurantException extends RuntimeException {
    static String message = "This dish does not belong to the provided restaurant!";

    public DishDoesNotBelongToRestaurantException() {
        super(DishDoesNotBelongToRestaurantException.message);
    }

    public DishDoesNotBelongToRestaurantException(String message) {
        super(message);
    }

    public DishDoesNotBelongToRestaurantException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishDoesNotBelongToRestaurantException(Throwable cause) {
        super(DishDoesNotBelongToRestaurantException.message, cause);
    }
}
