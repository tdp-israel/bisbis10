package com.att.tdp.bisbis10.entitys;

public enum Cuisine {
    ASIAN("Asian"),
    MEXICAN("Mexican"),
    INDIAN("Indian");

    Cuisine(String name) {

    }

    public static Cuisine getCuisineByString(String cuisineString) {
        for (Cuisine cuisine : Cuisine.values()) {
            if (cuisine.name().equalsIgnoreCase(cuisineString)) {
                return cuisine;
            }
        }
        return null;
    }
}
