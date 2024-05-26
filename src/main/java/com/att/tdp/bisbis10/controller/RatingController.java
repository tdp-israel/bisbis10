package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating newRating = ratingService.addRating(rating);
        return newRating != null ? ResponseEntity.ok(newRating) : ResponseEntity.notFound().build();
    }
}
