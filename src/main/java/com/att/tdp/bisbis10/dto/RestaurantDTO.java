package com.att.tdp.bisbis10.dto;

import jakarta.persistence.ElementCollection;

import java.util.List;

public record RestaurantDTO(
        Long id,
        String name,
        Double rating,
        Boolean isKosher,
        @ElementCollection
        List<String> cuisines) {
}
