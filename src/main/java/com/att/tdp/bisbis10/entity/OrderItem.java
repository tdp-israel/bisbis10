package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class OrderItem {
    @Id
    @SequenceGenerator(
        name = "order_item_sequeunce",
        sequenceName = "order_item_sequeunce",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "order_item_sequeunce"
    )
    @JsonIgnore
    private Integer id;
    private Integer amount;

    @OneToOne
    @JsonIgnore
    private Dish dish;

    @Transient
    private Integer dishId;

    @ManyToOne
    @JsonIgnore
    RestaurantOrder order;


    public OrderItem() {
    }

    public OrderItem(Integer amount, Dish dish, RestaurantOrder order) {
        this.amount = amount;
        this.dish = dish;
        this.order = order;
    }

    public OrderItem(Integer id, Integer amount, Dish dish, RestaurantOrder order) {
        this.id = id;
        this.amount = amount;
        this.dish = dish;
        this.order = order;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", dishId='" + getDishId() + "'" +
            ", orderId='" + getOrder().getId() + "'" +
            "}";
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Dish getDish() {
        return this.dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public RestaurantOrder getOrder() {
        return this.order;
    }

    public void setOrder(RestaurantOrder order) {
        this.order = order;
    }

    public Integer getDishId() {
        if(this.dish != null) {
            return dish.getId();
        }
        return this.dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

}
