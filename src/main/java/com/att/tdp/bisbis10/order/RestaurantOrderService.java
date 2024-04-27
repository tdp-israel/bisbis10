package com.att.tdp.bisbis10.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.OrderItem.OrderItem;
import com.att.tdp.bisbis10.OrderItem.OrderItemService;
import com.att.tdp.bisbis10.dish.Dish;
import com.att.tdp.bisbis10.dish.DishService;
import com.att.tdp.bisbis10.restaurant.Restaurant;
import com.att.tdp.bisbis10.restaurant.RestaurantService;

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
    
    public void addRestaurantOrder(RestaurantOrder restaurantOrder) {
        Long restaurantId = restaurantOrder.getRestaurantId();
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        List<OrderItem> orderItems = new ArrayList<>();

        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId);
        
        for (OrderItem orderItem : restaurantOrder.getOrderItems()) {
            orderItem.setOrder(restaurantOrder);
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
        restaurantOrder.setRestaurant(restaurant);
        restaurantOrder = restaurantOrderRepository.save(restaurantOrder);

        // Save Order Items to DB
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(restaurantOrder);
            orderItem = orderItemService.addOrderItem(orderItem);
        }
        restaurantOrder.setOrderItems(orderItems);
    }
}
