package com.att.tdp.bisbis10.order;

import java.util.List;

import com.att.tdp.bisbis10.OrderItem.OrderItem;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class RestaurantOrder {
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

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    
    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;
    
    @Transient
    private Long restaurantId;

    public RestaurantOrder() {
    }

    public RestaurantOrder(Long id, Restaurant restaurant, List<OrderItem> orderItems) {
        this.id = id;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.restaurantId = restaurantId;
    }

    public RestaurantOrder(Restaurant restaurant, List<OrderItem> orderItems) {
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.restaurantId = restaurantId;
    }


    @Override
    public String toString() {
        return "RestaurantOrder {" +
            " id='" + getId() + "'" +
            ", restaurant='" + getRestaurant() + "'" +
            ", orderItems=[" + getOrderItems() + "]" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        if(this.restaurant != null) {
            return this.restaurant.getId();
        }
        return this.restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

}
