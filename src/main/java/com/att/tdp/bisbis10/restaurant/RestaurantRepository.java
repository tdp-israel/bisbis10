package com.att.tdp.bisbis10.restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.cuisines WHERE ?1 IN (SELECT cuisine FROM r.cuisines)")
    public List<Restaurant> findRestaurantsByCausine(String cuisine);
}
