package com.att.tdp.bisbis10.entitys;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "restaurant ")
@Table(name = "restaurant ")
public class Restaurant {
    @Id
    @GeneratedValue
            (
            strategy = GenerationType.IDENTITY
            )
    private Long id;
    @Column(name = "restaurant_name",nullable = false,length = 60)
    private String name;
    @Column(name = "is_kosher",nullable = false)
    private Boolean isKosher;

    @ElementCollection(targetClass = Cuisine.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "restaurant_cuisines", joinColumns = @JoinColumn(name = "restaurant_id"))
    private Set<Cuisine> cuisines;

    @OneToMany(mappedBy = "restaurantId", cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Dish> dishes;

    @Transient
    private double rating;


    public Restaurant() {
    }
    public Restaurant(String name, Boolean isKosher, Set<Cuisine> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getKosher() {
        return isKosher;
    }

    public void setKosher(Boolean kosher) {
        isKosher = kosher;
    }

    public Set<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
