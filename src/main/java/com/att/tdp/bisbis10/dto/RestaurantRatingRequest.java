package com.att.tdp.bisbis10.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RestaurantRatingRequest {
    
    @NotNull(message = "restaurantId must be provided!")
    private Integer restaurantId;
    @NotNull(message = "Rating must be provided!")
    @Min(value = 1, message = "the rating needs to be at least 1!")
    @Max(value = 5, message = "The rating needs to be at most 5!")
    private Float rating;

    public RestaurantRatingRequest() {
    }


    @Override
    public String toString() {
        return "{" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    public Integer getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Float getRating() {
        return this.rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

}
