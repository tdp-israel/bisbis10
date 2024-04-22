package com.att.tdp.bisbis10.restaurant;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.att.tdp.bisbis10.restaurantcuisine.RestaurantCuisine;
import com.att.tdp.bisbis10.restaurantrating.RestaurantRating;
import com.att.tdp.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantCuisine> cuisines_;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantRating> ratings;

    @Transient
    private float averageRating;
    @Transient
    private List<String> cuisines;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, List<RestaurantRating> ratings, boolean isKosher, List<RestaurantCuisine> cuisines) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
        this.isKosher = isKosher;
        this.cuisines_ = cuisines;
    }

    public Restaurant(String name, List<RestaurantRating> ratings, boolean isKosher, List<RestaurantCuisine> cuisines) {
        this.name = name;
        this.ratings = ratings;
        this.isKosher = isKosher;
        this.cuisines_ = cuisines;
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
        List<Float> ratings = this.ratings.stream()
            .map(RestaurantRating::getRating)
            .collect(Collectors.toList());
        this.averageRating = Utils.average(ratings);
        return this.averageRating;
    }

    public List<RestaurantRating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<RestaurantRating> ratings) {
        this.ratings = ratings;
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

    public List<RestaurantCuisine> getCuisines_() {
        return this.cuisines_;
    }

    public void setCuisines_(List<RestaurantCuisine> cuisines) {
        this.cuisines_ = cuisines;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getCuisines() {
        this.cuisines = this.cuisines_.stream()
            .map(RestaurantCuisine::getCuisine)
            .collect(Collectors.toList());
        return this.cuisines;
    }
}
