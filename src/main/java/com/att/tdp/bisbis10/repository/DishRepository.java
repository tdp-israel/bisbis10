package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query("SELECT d FROM Dish d WHERE :restId = d.restaurant.id")
    List<Dish> getDishesByRestaurantId(@Param("restId") Long restId);
}
