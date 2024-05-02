package com.att.tdp.bisbis10.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DishRequest {
    @NotBlank(message = "name must not be empty!")
    private String name;
    @NotBlank(message = "description must not be empty!")
    private String description;
    @NotNull(message = "price must be provided!")
    @Min(value = 0, message = "price can not be a negative value!")
    private Float price;

    public DishRequest() {
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
