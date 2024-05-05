package com.att.tdp.bisbis10.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;

public class RestaurantDTO {
    @NotNull(message = "name field is required")
    final String name;

    @NotNull(message = "isKosher field is required")
    final boolean isKosher;

    @NotNull(message = "cuisines array field is required")

    final String[] cuisines;


    public RestaurantDTO(String name, boolean isKosher, String[] cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public String getName() {
        return name;
    }

    public boolean getKosher() {
        return isKosher;
    }

    public String[] getCuisines() {
        return cuisines;
    }
}
