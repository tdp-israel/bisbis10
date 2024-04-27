package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Dish {
    @Id
    @SequenceGenerator(
        name = "dish_sequeunce",
        sequenceName = "dish_sequeunce",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "dish_sequeunce"
    )
    private Long id;
    private String name;
    private String description;
    private Float price;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    @Transient
    private Long restaurantId;

    public Dish() {
    }

    public Dish(Long id, Restaurant restaurant, String name, String description, Float price) {
        this.id = id;
        this.restaurant = restaurant;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Dish(Restaurant restaurant, String name, String description, Float price) {
        this.restaurant = restaurant;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Dish {" +
            " id='" + getId() + "'" +
            ", restaurantId='" + getRestaurant() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getRestaurantId() {
        if(restaurant != null) {
            return this.restaurant.getId();
        }
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getRestaurant() {
        return this.restaurant.getId();
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
