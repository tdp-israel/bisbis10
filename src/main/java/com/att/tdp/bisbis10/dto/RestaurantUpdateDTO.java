package com.att.tdp.bisbis10.dto;

public class RestaurantUpdateDTO {
    private final String name;
    private final Boolean isKosher;

    final String[] newCuisines;
    final String[] deleteCuisines;

    public RestaurantUpdateDTO(String name, Boolean isKosher, String[] newCuisines, String[] deleteCuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.newCuisines = newCuisines;
        this.deleteCuisines = deleteCuisines;
    }

    public String getName() {
        return name;
    }

    public Boolean getKosher() {
        return isKosher;
    }

    public String[] getNewCuisines() {
        return newCuisines;
    }

    public String[] getDeleteCuisines() {
        return deleteCuisines;
    }
}
