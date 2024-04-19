package com.att.tdp.bisbis10.order;

public class OrderItem {
    private Long id;
    private Long orderId;

    public OrderItem() {
    }

    public OrderItem(Long id, Long orderId, Long dishId) {
        this.id = id;
        this.orderId = orderId;
        this.dishId = dishId;
    }

    public OrderItem(Long orderId, Long dishId) {
        this.orderId = orderId;
        this.dishId = dishId;
    }


    @Override
    public String toString() {
        return "OrderItem {" +
            " id='" + getId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", dishId='" + getDishId() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishId() {
        return this.dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    private Long dishId;
}