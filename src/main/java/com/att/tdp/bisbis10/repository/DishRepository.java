package com.att.tdp.bisbis10.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.att.tdp.bisbis10.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = ?1")
    public List<Dish> getDishesByRestaurantId(Integer restaurantId);

    public Page<Dish> getDishesByRestaurantId(Integer restaurantId, Pageable pageable);
}
