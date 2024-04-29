package com.att.tdp.bisbis10.dto;

import java.util.UUID;

public class OrderResponse {
    private UUID orderId;

    public OrderResponse() {
    }

    public OrderResponse(UUID orderId) {
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "{" +
            "}";
    }

    public UUID getOrderId() {
        return this.orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

}
