package com.att.tdp.bisbis10.dto;

import jakarta.annotation.Nonnull;

public class RatingDTO {

    @Nonnull
    private final long restaurantId;
    @Nonnull
    private final double rating;


    public RatingDTO(double rating, long restaurantId) {
        this.rating = rating;
        this.restaurantId = restaurantId;
    }

    public double getRate() {
        return rating;
    }

    public long getRestaurantID() {
        return restaurantId;
    }
}
