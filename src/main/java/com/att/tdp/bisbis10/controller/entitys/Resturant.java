package com.att.tdp.bisbis10.controller.entitys;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "resturant")
@Table(name = "resturant")
public class Resturant {
    @Id
    @GeneratedValue
            (
                    strategy = GenerationType.IDENTITY
            )
    private Long id;
    @Column(name = "resturant_name",nullable = false,length = 60)
    private String name;
    @Column(name = "is_kosher",nullable = false)
    private Boolean isKosher;

    @ElementCollection
    private Set<Cuisine> cuisines;
}
