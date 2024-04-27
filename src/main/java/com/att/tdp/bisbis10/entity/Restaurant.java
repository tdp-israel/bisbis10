package com.att.tdp.bisbis10.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.att.tdp.utils.Utils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table
public class Restaurant {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private boolean isKosher;

    @ElementCollection
    private List<String> cuisines;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantRating> ratings;

    @Transient
    private float averageRating;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<RestaurantRating> ratings, boolean isKosher, List<String> cuisines) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(String name, boolean isKosher, List<String> cuisines) {
        this.name = name;
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAverageRating() {
        if(this.ratings != null) {
            List<Float> ratings = this.ratings.stream()
                .map(RestaurantRating::getRating)
                .collect(Collectors.toList());
            return Utils.average(ratings);
        }
        return this.averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
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

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
}
