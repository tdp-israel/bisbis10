package com.att.tdp.bisbis10.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestaurantRequest {

    @NotBlank(message = "Restaurant name must not be empty!")
    private String name;
    @NotNull(message = "Restaurant kosher status must be provided!")
    private Boolean isKosher;
    @NotNull(message = "Cuisines must be a list of strings!")
    private Set<String> cuisines;


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", isKosher='" + isIsKosher() + "'" +
            ", cuisines='" + getCuisines() + "'" +
            "}";
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

}
