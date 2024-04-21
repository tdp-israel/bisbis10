package com.att.tdp.bisbis10.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantOrderService {
    RestaurantOrderRepository orderRepository;

    @Autowired
    public RestaurantOrderService(RestaurantOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
}
