package com.att.tdp.bisbis10.order;

import java.util.List;

import com.att.tdp.bisbis10.OrderItem.OrderItem;

public class OrderCreateRequest {
    Long restaurantId;
    List<OrderItem> orderItems;


    public OrderCreateRequest() {
    }

    public OrderCreateRequest(Long restaurantId, List<OrderItem> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }


    @Override
    public String toString() {
        return "{" +
            " restaurantId='" + getRestaurantId() + "'" +
            ", orderItems='" + getOrderItems() + "'" +
            "}";
    }

    public Long getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
