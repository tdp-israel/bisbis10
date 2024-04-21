package com.att.tdp.bisbis10.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class RestaurantOrderController {
    RestaurantOrderService orderService;

    @Autowired
    public RestaurantOrderController(RestaurantOrderService orderService) {
        this.orderService = orderService;
    }

}
