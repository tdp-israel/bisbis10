package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.model.Rating;
import com.att.tdp.bisbis10.model.Restaurant;
import com.att.tdp.bisbis10.repository.RatingRepository;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Rating addRating(Rating rating) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rating.getRestaurantId());
        if (restaurant.isPresent()) {
            double newAverage = (restaurant.get().getAverageRating() + rating.getRating()) / 2;
            restaurant.get().setAverageRating(newAverage);
            restaurantRepository.save(restaurant.get());
            return ratingRepository.save(rating);
        }
        return null;
    }
}
