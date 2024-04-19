package com.att.tdp.bisbis10.dish;

public class Dish {
    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private Integer price;

    public Dish() {
    }

    public Dish(Long id, Long restaurantId, String name, String description, Integer price) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Dish(Long restaurantId, String name, String description, Integer price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Dish {" +
            " id='" + getId() + "'" +
            ", restaurantId='" + getRestaurantId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
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

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
