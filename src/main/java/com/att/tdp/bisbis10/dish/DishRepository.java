package com.att.tdp.bisbis10.dish;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = ?1")
    public List<Dish> getDishesByRestaurantId(Long restaurantId);
}
