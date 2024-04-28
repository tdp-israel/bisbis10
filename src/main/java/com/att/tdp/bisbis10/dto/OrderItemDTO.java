package com.att.tdp.bisbis10.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemDTO {
    @NotNull(message = "dishId must be provided for orderItem!")
    private Integer dishId;
    @NotNull(message = "amount must be provided for orderItem!")
    @Min(value = 1, message = "orderItem amount must be atleast 1!")
    private Integer amount;

    public OrderItemDTO() {
    }


    @Override
    public String toString() {
        return "{" +
            " dishId='" + getDishId() + "'" +
            ", amount='" + getAmount() + "'" +
            "}";
    }

    public Integer getDishId() {
        return this.dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
