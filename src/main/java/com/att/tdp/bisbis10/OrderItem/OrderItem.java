package com.att.tdp.bisbis10.OrderItem;

import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.order.RestaurantOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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
    Long id;
    Integer amount;
    Dish dish;

    @ManyToOne
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
            ", dish='" + getDish() + "'" +
            ", order='" + getOrder() + "'" +
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

    public Long getOrder() {
        return this.order.getId();
    }

    public void setOrder(RestaurantOrder order) {
        this.order = order;
    }

}
