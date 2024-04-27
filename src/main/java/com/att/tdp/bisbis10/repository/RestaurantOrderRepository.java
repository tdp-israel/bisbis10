package com.att.tdp.bisbis10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.att.tdp.bisbis10.entity.RestaurantOrder;

@Repository
public interface RestaurantOrderRepository extends JpaRepository<RestaurantOrder, Long>{
    
}
