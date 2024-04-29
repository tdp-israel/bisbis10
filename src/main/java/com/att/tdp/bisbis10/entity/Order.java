package com.att.tdp.bisbis10.entity;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
        strategy = GenerationType.UUID
    )
    @JsonIgnore
    private UUID id;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
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
