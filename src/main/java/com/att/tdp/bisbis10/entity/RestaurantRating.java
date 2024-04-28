package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class RestaurantRating {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private Float rating;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    // if restaurant is null, getRestaurantId returns -1
    @Transient
    private Integer restaurantId;

    public RestaurantRating() {
    }

    public RestaurantRating(float rating, Restaurant restaurant) {
        this.rating = rating;
        this.restaurant = restaurant;
    }


    @Override
    public String toString() {
        return "RestaurantRating {" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", rating='" + getRating() + "'" +
            "}";
    }

    public Integer getRestaurantId() {
        if(this.restaurant != null) {
            return this.restaurant.getId();
        }
        return -1;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurant() {
        return this.restaurant.getId();
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.restaurantId = restaurant.getId();
    }
}
