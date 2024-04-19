package com.att.tdp.bisbis10.order;

public class Order {
    private Long id;
    private Long restaurantId;

    public Order() {
    }

    public Order(Long id, Long restaurantId) {
        this.id = id;
        this.restaurantId = restaurantId;
    }

    public Order(Long restaurantId) {
        this.restaurantId = restaurantId;
    }



    @Override
    public String toString() {
        return "Order {" +
            " id='" + getId() + "'" +
            ", restaurantId='" + getRestaurantId() + "'" +
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

}
