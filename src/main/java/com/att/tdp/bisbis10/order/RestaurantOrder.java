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
    @ManyToOne
    private Restaurant restaurant;
    @OneToMany
    private List<Dish> orderItems;

    @Transient
    private Long restaurantId;

    public RestaurantOrder() {
    }


    public RestaurantOrder(Long id, Restaurant restaurant, List<Dish> orderItems, Long restaurantId) {
        this.id = id;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.restaurantId = restaurantId;
    }

    public RestaurantOrder(Restaurant restaurant, List<Dish> orderItems, Long restaurantId) {
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.restaurantId = restaurantId;
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

    public Restaurant getRestaurant() {
        return this.restaurant;
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
