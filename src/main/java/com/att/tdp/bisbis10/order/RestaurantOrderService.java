package com.att.tdp.bisbis10.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.OrderItem.OrderItem;
import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantService;

@Service
public class RestaurantOrderService {
    RestaurantOrderRepository restaurantOrderRepository;
    RestaurantService restaurantService;

    @Autowired
    public RestaurantOrderService(RestaurantOrderRepository restaurantOrderRepository, RestaurantService restaurantService) {
        this.restaurantOrderRepository = restaurantOrderRepository;
        this.restaurantService = restaurantService;
    }
    
    public void addRestaurantOrder(OrderCreateRequest orderCreateRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(orderCreateRequest.getRestaurantId());
        List<Dish> orderItems = new ArrayList<>();
        // TODO
        // Add Dish does not exist error
        for ( OrderItem orderItem : orderCreateRequest.getOrderItems()) {
            
        }
        RestaurantOrder restaurantOrder = new RestaurantOrder(restaurant, orderItems);
        restaurantOrderRepository.save(restaurantOrder);
    }
}
