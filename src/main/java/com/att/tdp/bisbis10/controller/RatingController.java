package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RestaurantService restService;

    @PostMapping
    ResponseEntity<?> addRating(@RequestBody RatingDTO rating){
        restService.addRating(rating.restaurantId(), rating.rating());
//        ratingService.addRating(rating);
        return ResponseEntity.ok(null);
    }


}
