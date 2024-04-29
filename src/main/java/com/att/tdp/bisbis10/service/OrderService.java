package com.att.tdp.bisbis10.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.OrderItemDTO;
import com.att.tdp.bisbis10.dto.OrderRequest;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.OrderItem;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.entity.Order;
import com.att.tdp.bisbis10.repository.OrderRepository;

@Service
public class OrderService {
    OrderRepository orderRepository;
    OrderItemService orderItemService;
    RestaurantService restaurantService;
    DishService dishService;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantService restaurantService, DishService dishService, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.restaurantService = restaurantService;
        this.dishService = dishService;
        this.orderItemService = orderItemService;
    }
    
    public Order addOrder(OrderRequest orderRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(
            orderRequest.getRestaurantId()
        );
        Order order = new Order(restaurant);

        // Build orderItems List
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDTO orderItemDto : orderRequest.getOrderItems()) {
            Dish dish = dishService.getDishById(
                orderItemDto.getDishId(), 
                restaurant.getId()
            );
            orderItems.add(
                new OrderItem(
                    orderItemDto.getAmount(),
                    dish,
                    order
                )
            );
        }

        // Save Order and OrderItems
        order.setOrderItems(orderItems);
        orderRepository.save(order);
        orderItems.forEach(orderItem -> 
            orderItemService.addOrderItem(orderItem)
        );

        return order;
    }
}
