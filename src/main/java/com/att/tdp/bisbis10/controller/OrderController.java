package com.att.tdp.bisbis10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.dto.OrderRequest;
import com.att.tdp.bisbis10.entity.Order;
import com.att.tdp.bisbis10.service.RestaurantOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
    RestaurantOrderService restaurantOrderService;

    @Autowired
    public OrderController(RestaurantOrderService restaurantOrderService) {
        this.restaurantOrderService = restaurantOrderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurantOrder(@Valid @RequestBody OrderRequest orderRequest) {
        System.out.println(orderRequest.getOrderItems());
        // restaurantOrderService.addRestaurantOrder(orderRequest);
    }
}
