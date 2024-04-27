package com.att.tdp.bisbis10.OrderItem;

import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.order.RestaurantOrder;
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
    private Long id;
    private Integer amount;

    @OneToOne
    @JsonIgnore
    private Dish dish;

    @Transient
    private Long dishId;

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

    public OrderItem(Long id, Integer amount, Dish dish, RestaurantOrder order) {
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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public Long getDishId() {
        if(this.dish != null) {
            return dish.getId();
        }
        return this.dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

}
