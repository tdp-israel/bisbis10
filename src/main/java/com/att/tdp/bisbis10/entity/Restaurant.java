package com.att.tdp.bisbis10.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.att.tdp.utils.MathUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table
public class Restaurant {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column(columnDefinition = "varchar(60)")
    private String name;
    private Boolean isKosher;

    @ElementCollection
    private Set<String> cuisines;

    @Transient
    private float averageRating;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RestaurantRating> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(String name, Boolean isKosher, Set<String> cuisines) {
        this.name = name;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Restaurant other = (Restaurant) obj;
        
        return 
            (id == null || id.equals(id)) &&
            name.equals(other.name) &&
            isKosher.equals(other.isKosher) &&
            cuisines.equals(other.cuisines);
    }

    @Override
    public String toString() {
        return "Restaurant {" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", averageRating='" + getAverageRating() + "'" +
            ", isKosher='" + getIsKosher() + "'" +
            ", cuisines='" + getCuisines() + "'" +
            "}";
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAverageRating() {
        Float average = 0f;

        if(this.ratings != null) {
            List<Float> ratings = this.ratings.stream()
                .map(RestaurantRating::getRating)
                .collect(Collectors.toList());
            average = MathUtils.average(ratings);
        }
        
        average = MathUtils.roundTo2Decimals(average);
        return average;
    }

    public List<RestaurantRating> getRatings() {
        return this.ratings;
    }

    public void setRatings(List<RestaurantRating> ratings) {
        this.ratings = ratings;
    }

    public Boolean getIsKosher() {
        return this.isKosher;
    }

    public void setIsKosher(Boolean isKosher) {
        this.isKosher = isKosher;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public Set<String> getCuisines() {
        return this.cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public Boolean isIsKosher() {
        return this.isKosher;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
