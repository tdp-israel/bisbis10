package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Dish;
import com.att.tdp.bisbis10.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{restaurantId}/dishes")
public class DishController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long restaurantId) {
        List<Dish> dishes = dishService.getDishesByRestaurant(restaurantId);
        return dishes != null ? ResponseEntity.ok(dishes) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Dish> addDishToRestaurant(@PathVariable Long restaurantId, @RequestBody Dish dish) {
        Dish newDish = dishService.addDishToRestaurant(restaurantId, dish);
        return newDish != null ? ResponseEntity.status(201).body(newDish) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long dishId, @RequestBody Dish dish) {
        Dish updatedDish = dishService.updateDish(dishId, dish);
        return updatedDish != null ? ResponseEntity.ok(updatedDish) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
        return ResponseEntity.noContent().build();
    }
}

