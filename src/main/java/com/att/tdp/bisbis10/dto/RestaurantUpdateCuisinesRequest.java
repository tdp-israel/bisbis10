package com.att.tdp.bisbis10.dto;

import java.util.Set;

import jakarta.validation.constraints.NotNull;

public class RestaurantUpdateCuisinesRequest {
    
    @NotNull(message = "Cuisines must be a list of strings!")
    private Set<String> cuisines;


    @Override
    public String toString() {
        return "{" +
            " cuisines='" + getCuisines() + "'" +
            "}";
    }

    public Set<String> getCuisines() {
        System.out.println(this.cuisines);
        return this.cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }
    
}
