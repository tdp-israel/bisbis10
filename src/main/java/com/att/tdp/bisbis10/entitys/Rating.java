package com.att.tdp.bisbis10.entitys;

import jakarta.persistence.*;


@Entity(name = "rating")
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue
            (
                    strategy = GenerationType.IDENTITY
            )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;


    @Column(name = "rate",nullable = false)
    private int rate;
}
