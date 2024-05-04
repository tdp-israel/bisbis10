package com.att.tdp.bisbis10.dto;

import jakarta.annotation.Nonnull;

public class RestaurantDTO {
    @Nonnull
    final String name;

    @Nonnull
    final Boolean isKosher;

    @Nonnull
    final String[] cuisines;



    public RestaurantDTO(String name, Boolean isKosher, String[] cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public String getName() {
        return name;
    }

    public Boolean getKosher() {
        return isKosher;
    }

    public String[] getCuisines() {
        return cuisines;
    }
}
