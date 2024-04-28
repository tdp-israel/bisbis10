package com.att.tdp.bisbis10.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.OrderRequest;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.OrderItem;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.entity.Order;
import com.att.tdp.bisbis10.repository.RestaurantOrderRepository;

@Service
public class RestaurantOrderService {
    RestaurantOrderRepository restaurantOrderRepository;
    OrderItemService orderItemService;
    RestaurantService restaurantService;
    DishService dishService;

    @Autowired
    public RestaurantOrderService(RestaurantOrderRepository restaurantOrderRepository, RestaurantService restaurantService, DishService dishService, OrderItemService orderItemService) {
        this.restaurantOrderRepository = restaurantOrderRepository;
        this.restaurantService = restaurantService;
        this.dishService = dishService;
        this.orderItemService = orderItemService;
    }
    
    public void addRestaurantOrder(OrderRequest orderRequest) {


        Integer restaurantId = orderRequest.getRestaurantId();
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        List<OrderItem> orderItems = new ArrayList<>();

        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId);
        
        for (OrderItem orderItem : orderRequest.getOrderItems()) {
            orderItem.setOrder(orderRequest);
            for (Dish dish : dishes) {
                if(dish.getId() == orderItem.getDishId()) {
                    orderItem.setDish(dish);
                    break;
                }
            }
            if(orderItem.getDish() == null) {
                System.out.println("Dish does not exist in restaurant");
                // TODO
                // Throw error, dish does not exist in restaurant
            }
            orderItems.add(orderItem);
        }

        // Save Order to DB
        orderRequest.setRestaurant(restaurant);
        orderRequest = restaurantOrderRepository.save(orderRequest);

        // Save Order Items to DB
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(orderRequest);
            orderItem = orderItemService.addOrderItem(orderItem);
        }
        orderRequest.setOrderItems(orderItems);
    }
}
