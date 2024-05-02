package com.att.tdp.bisbis10.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Dish {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(columnDefinition = "varchar(60)")
    private String name;
    @Column(columnDefinition = "varchar(300)")
    private String description;
    private Float price;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public Dish() {
    }

    public Dish(Restaurant restaurant, String name, String description, Float price) {
        this.restaurant = restaurant;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Dish {" +
            " id='" + getId() + "'" +
            ", restaurantId='" + getRestaurant().getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
