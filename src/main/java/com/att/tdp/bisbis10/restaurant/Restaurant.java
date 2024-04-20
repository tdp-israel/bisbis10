package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import com.att.tdp.bisbis10.restaurantcuisine.RestaurantCuisine;

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
    private float averageRating;
    private boolean isKosher;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantCuisine> cuisines;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, float averageRating, boolean isKosher, List<RestaurantCuisine> cuisines) {
        this.id = id;
        this.name = name;
        this.averageRating = averageRating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Restaurant(String name, float averageRating, boolean isKosher, List<RestaurantCuisine> cuisines) {
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
        return this.averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
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
