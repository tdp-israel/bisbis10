package com.att.tdp.bisbis10.restaurantcuisine;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RestaurantCuisineId implements Serializable {
    private Long restaurantId;
    private String cuisine;


    public RestaurantCuisineId() {
    }
    

    public RestaurantCuisineId(Long restaurantId, String cuisine) {
        this.restaurantId = restaurantId;
        this.cuisine = cuisine;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
