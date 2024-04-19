package com.att.tdp.bisbis10.restaurantrating;

public class RestaurantRating {
    private Long restaurantId;
    private float rating;

    public RestaurantRating() {
    }

    public RestaurantRating(Long restaurantId, float rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }



    @Override
    public String toString() {
        return "RestaurantRating {" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
