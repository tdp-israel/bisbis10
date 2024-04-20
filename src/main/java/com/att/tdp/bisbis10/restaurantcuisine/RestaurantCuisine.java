package com.att.tdp.bisbis10.restaurantcuisine;

import com.att.tdp.bisbis10.restaurant.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
public class RestaurantCuisine {
    @Id
    @SequenceGenerator(
        name = "restaurant_cuisine_sequeunce",
        sequenceName = "restaurant_cuisine_sequeunce",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restaurant_cuisine_sequeunce"
    )
    private Long id;
    private String cuisine;

    @ManyToOne
    private Restaurant restaurant;

    public RestaurantCuisine() {
    }

    public RestaurantCuisine(Long id, String cuisine) {
        this.id = id;
        this.cuisine = cuisine;
    }

    public RestaurantCuisine(String cuisine) {
        this.cuisine = cuisine;
    }



    @Override
    public String toString() {
        return "RestaurantCuisine{" +
            " id='" + getId() + "'" +
            ", cuisine='" + getCuisine() + "'" +
            ", restaurantId='" + getRestaurant().getId() + "'" +
            "}";
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}