package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import com.att.tdp.bisbis10.restaurantcuisine.RestaurantCuisine;
import com.att.tdp.bisbis10.restaurantrating.RestaurantRating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table
public class Restaurant {
    @Id
    @SequenceGenerator(
        name = "restaurant_sequence",
        sequenceName = "restaurant_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restaurant_sequeunce"
    )
    private Long id;
    private String name;
    private boolean isKosher;

    @OneToMany
    private List<RestaurantRating> averageRating;
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantCuisine> cuisines;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, List<RestaurantRating> averageRating, boolean isKosher, List<RestaurantCuisine> cuisines) {
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(String name, List<RestaurantRating> averageRating, boolean isKosher, List<RestaurantCuisine> cuisines) {
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }        



    @Override
    public String toString() {
        return "Restaurant {" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", averageRating='" + getAverageRating() + "'" +
            ", isKosher='" + isIsKosher() + "'" +
            ", cuisines='" + getCuisines() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverageRating() {
        float ratingsSum = 0;
        float averageRating = 0;
        for (RestaurantRating rating : this.averageRating) {
            ratingsSum += rating.getRating();
        }
        averageRating = ratingsSum / this.averageRating.size();
        return averageRating;
    }

    public void setAverageRating(List<RestaurantRating> restaurantRatings) {
        this.averageRating = restaurantRatings;
    }

    public boolean isIsKosher() {
        return this.isKosher;
    }

    public boolean getIsKosher() {
        return this.isKosher;
    }

    public void setIsKosher(boolean isKosher) {
        this.isKosher = isKosher;
    }

    public List<RestaurantCuisine> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(List<RestaurantCuisine> cuisines) {
        this.cuisines = cuisines;
    }
}
