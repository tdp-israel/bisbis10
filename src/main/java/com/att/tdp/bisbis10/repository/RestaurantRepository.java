package com.att.tdp.bisbis10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.att.tdp.bisbis10.entity.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    
    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.cuisines_ WHERE ?1 IN (SELECT cuisine FROM r.cuisines_)")
    public List<Restaurant> findRestaurantsByCausine(String cuisine);
}
