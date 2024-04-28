package com.att.tdp.bisbis10.exception.dish;

import com.att.tdp.bisbis10.exception.ItemNotFoundException;

public class DishNotFoundException extends ItemNotFoundException {
    static String message = "No dish found with this id!";

    public DishNotFoundException() {
        super(DishNotFoundException.message);
    }

    public DishNotFoundException(String message) {
        super(message);
    }

    public DishNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DishNotFoundException(Throwable cause) {
        super(DishNotFoundException.message, cause);
    }
}
