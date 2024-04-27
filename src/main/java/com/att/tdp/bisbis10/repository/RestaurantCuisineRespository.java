package com.att.tdp.bisbis10.restaurantcuisine;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantCuisineRespository extends JpaRepository<RestaurantCuisine, Long> {
   
}