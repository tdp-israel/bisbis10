package com.att.tdp.bisbis10.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_order")
public class Order {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @JsonIgnore
    private Integer id;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderItem> orderItems;
    
    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    public Order() {
    }

    public Order(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Order(List<OrderItem> orderItems, Restaurant restaurant) {
        this.orderItems = orderItems;
        this.restaurant = restaurant;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", orderItems='" + getOrderItems() + "'" +
            ", restaurant='" + getRestaurant() + "'" +
            "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
