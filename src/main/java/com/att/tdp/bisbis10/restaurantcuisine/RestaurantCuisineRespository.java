package com.att.tdp.bisbis10.restaurantcuisine;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantCuisineRespository extends JpaRepository<RestaurantCuisine, RestaurantCuisineId> {
    
    // @Query("SELECT rc.cuisine FROM RestaurantCuisine rc WHERE rc.restaurantCuisineId.restaurantId = ?1")
    // public List<String> findCuisineByRestaurantId(Long restaurantId);
}
