package com.att.tdp.bisbis10.entitys;

import jakarta.persistence.*;


@Entity(name = "rating")
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
            )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @Column(name = "rate",nullable = false)
    private int rate;

    public Rating(Restaurant restaurant, int rate) {
        this.restaurant = restaurant;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getRate() {
        return rate;
    }
}
