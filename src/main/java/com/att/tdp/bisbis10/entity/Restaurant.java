package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    private @Id @GeneratedValue Long id;
    private String name;
    private float rating;
    private boolean isKosher;
    @ElementCollection
    private List<String> cuisines;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Restaurant() {}
//    public Restaurant(String name, boolean is_kosher, List<String> cuisines){
//        this.name=name;
//        this.isKosher = is_kosher;
//        this.cuisines=cuisines;
//    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean getIsKosher() {
        return isKosher;
    }

    public void setIsKosher(boolean is_kosher) {
        this.isKosher = is_kosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = new ArrayList<>(cuisines);
    }
}
