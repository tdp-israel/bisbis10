package com.att.tdp.bisbis10.entitys;


import jakarta.persistence.*;

@Entity(name = "dish")
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue
            (
            strategy = GenerationType.IDENTITY
            )
    private Long id;
    @Column(name = "dish_name",nullable = false,length = 60)
    private String name;
    @Column(name = "dish_description",length = 200)
    private String description;
    @Column(name = "dish_price",nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;

}
