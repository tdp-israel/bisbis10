package com.att.tdp.bisbis10.dto;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record RestaurantDTO(
        Long id,
        @NotEmpty
        String name,
        Float rating,
        Boolean isKosher,
        @ElementCollection
        List<String> cuisines) {
}
