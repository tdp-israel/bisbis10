package com.att.tdp.bisbis10.dto;

import jakarta.annotation.Nonnull;

public class RestaurantDTO {
    @Nonnull
    final String name;

    @Nonnull
    final boolean isKosher;

    @Nonnull
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
