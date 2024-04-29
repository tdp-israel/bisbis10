package com.att.tdp.bisbis10.dto;

import java.util.List;
import java.util.Set;

import com.att.tdp.bisbis10.entity.Dish;

public class RestaurantWithDishesDTO {
    private Integer id;
    private String name;
    private Boolean isKosher;
    private Set<String> cuisines;
    private float averageRating;
    private List<Dish> dishes;


    public RestaurantWithDishesDTO() {
    }

    public RestaurantWithDishesDTO(Integer id, String name, Boolean isKosher, Set<String> cuisines, float averageRating, List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
        this.averageRating = averageRating;
        this.dishes = dishes;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", isKosher='" + isIsKosher() + "'" +
            ", cuisines='" + getCuisines() + "'" +
            ", averageRating='" + getAverageRating() + "'" +
            ", dishes='" + getDishes() + "'" +
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

    public Boolean isIsKosher() {
        return this.isKosher;
    }

    public Boolean getIsKosher() {
        return this.isKosher;
    }

    public void setIsKosher(Boolean isKosher) {
        this.isKosher = isKosher;
    }

    public Set<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public float getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

}
