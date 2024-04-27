package com.att.tdp.bisbis10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.entity.OrderItem;
import com.att.tdp.bisbis10.repository.OrderItemRepository;

@Service
public class OrderItemService {
    OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem addOrderItem(OrderItem orderItem) {
        orderItem = this.orderItemRepository.save(orderItem);
        return orderItem;
    }
}
