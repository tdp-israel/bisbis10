package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    // @Query("SELECT r, ARRAY_AGG(rc.restaurantCuisineId.cuisine) WITHIN GROUP (ORDER BY NULL) AS cuisines FROM Restaurant r LEFT JOIN RestaurantCuisine rc ON r.id = rc.restaurantCuisineId.restaurantId GROUP BY r")
    // public List<Restaurant> findAllRestaurants();

    // @Query("SELECT r, ARRAY_AGG(rc.restaurantCuisineId.cuisine) WITHIN GROUP (ORDER BY NULL) AS cuisines FROM Restaurant r LEFT JOIN RestaurantCuisine rc ON r.id = rc.restaurantCuisineId.restaurantId GROUP BY r HAVING ?1 = ANY (SELECT rcc.restaurantCuisineId.cuisine FROM RestaurantCuisine rcc WHERE rcc.restaurantCuisineId.restaurantId = r.id)")
    // public List<Restaurant> findRestaurantsByCausine(String cuisine);
}
