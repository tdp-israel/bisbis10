package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class RestaurantRating {
    @Id
    @SequenceGenerator(
        name = "restaurant_rating_sequeunce",
        sequenceName = "restaurant_rating_sequeunce",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restaurant_rating_sequeunce"
    )
    private Integer id;
    private Float rating;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    @Transient
    private Integer restaurantId;

    public RestaurantRating() {
    }


    public RestaurantRating(Integer id, float rating, Restaurant restaurant) {
        this.id = id;
        this.rating = rating;
        this.restaurant = restaurant;
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
        return this.restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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
