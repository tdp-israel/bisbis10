package com.att.tdp.bisbis10.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {
    @NotNull(message = "restaurantId must be provided!")
    private Integer restaurantId;
    @Valid
    @NotNull(message = "orderItems must be provided!")
    private List<OrderItemDTO> orderItems;

    public OrderRequest() {
    }


    @Override
    public String toString() {
        return "{" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", orderItems='" + getOrderItems() + "'" +
            "}";
    }

    public Integer getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

}
