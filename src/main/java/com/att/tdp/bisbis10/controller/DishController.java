package com.att.tdp.bisbis10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.att.tdp.bisbis10.dto.DishRequest;
import com.att.tdp.bisbis10.dto.DishUpdateRequest;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.service.DishService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("restaurants/{restaurantId}/dishes")
public class DishController {
    DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getDishesByRestaurantId(@PathVariable Integer restaurantId,
                        @RequestParam(required = false) Integer page, 
                        @RequestParam(required = false) Integer pageSize) {
        List<Dish> dishes = dishService.getDishesByRestaurantId(restaurantId, page, pageSize);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dish> addDish(@PathVariable Integer restaurantId, @Valid @RequestBody DishRequest dishRequest) {
        Dish newDish = dishService.addDish(restaurantId, dishRequest);
        return new ResponseEntity<>(newDish, HttpStatus.CREATED);
    }

    @PutMapping("/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Integer restaurantId,
            @PathVariable Integer dishId, 
            @Valid @RequestBody DishUpdateRequest dishUpdateRequest)  {
        Dish updatedDish = dishService.updatedDish(restaurantId, dishId, dishUpdateRequest);
        return new ResponseEntity<>(updatedDish, HttpStatus.OK);
    }

    @DeleteMapping("/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Integer restaurantId, @PathVariable Integer dishId) {
        dishService.deleteDish(restaurantId, dishId);
        return ResponseEntity.noContent().build();
    }
}
