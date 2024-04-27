package com.att.tdp.bisbis10.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestaurantUpdateCuisinesRequest {
    
    @NotBlank(message = "Restaurant name must not be empty!")
    private String name;
    @NotNull(message = "Restaurant kosher status must be provided!")
    private Boolean isKosher;
    @NotNull(message = "Cuisines must be a list of strings!")
    private List<String> cuisines;


    @Override
    public String toString() {
        return "{" +
            " cuisines='" + getCuisines() + "'" +
            "}";
    }

    public List<String> getCuisines() {
        System.out.println(this.cuisines);
        return this.cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
    
}
