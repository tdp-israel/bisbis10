package com.att.tdp.bisbis10.restaurantcuisine;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class RestaurantCuisine {
    @EmbeddedId
    private RestaurantCuisineId restaurantCuisineId;

    @Transient
    private Long restaurantId;
    @Transient
    private String cuisine;

    public RestaurantCuisine() {
    }

    public RestaurantCuisine(Long restaurantId, String cuisine) {
        this.restaurantCuisineId = new RestaurantCuisineId(restaurantId, cuisine);
    }


    @Override
    public String toString() {
        return "RestaurantCuisine {" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", cuisine='" + getCuisine() + "'" +
            "}";
    }

    public Long getRestaurantId() {
        return this.restaurantCuisineId.getRestaurantId();
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantCuisineId.setRestaurantId(restaurantId);;
    }

    public String getCuisine() {
        return this.restaurantCuisineId.getCuisine();
    }

    public void setCuisine(String cuisine) {
        this.restaurantCuisineId.setCuisine(cuisine);
    }

}
