package com.att.tdp.bisbis10.restaurantrating;

import com.att.tdp.bisbis10.restaurant.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

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
    private Long id;
    private float rating;
    @ManyToOne
    private Restaurant restaurant;

    public RestaurantRating() {
    }


    public RestaurantRating(Long id, float rating, Restaurant restaurant) {
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

    public Long getRestaurantId() {
        return this.restaurant.getId();
    }

    public void setRestaurantId(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public float getRating() {
        return this.rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
