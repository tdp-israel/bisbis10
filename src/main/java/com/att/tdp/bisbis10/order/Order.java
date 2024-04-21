package com.att.tdp.bisbis10.order;

import java.util.List;

import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.restaurant.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(
        name = "order_sequence",
        sequenceName = "order_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "order_sequeunce"
    )
    private Long id;
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany
    private List<Dish> orderItems;

    public Order() {
    }

    public Order(Long id, Restaurant restaurant, List<Dish> orderItems) {
        this.id = id;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }

    public Order(Restaurant restaurant, List<Dish> orderItems) {
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", restaurant='" + getRestaurant() + "'" +
            ", orderItems='" + getOrderItems() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurant() {
        return this.restaurant.getId();
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<Dish> orderItems) {
        this.orderItems = orderItems;
    }

}
