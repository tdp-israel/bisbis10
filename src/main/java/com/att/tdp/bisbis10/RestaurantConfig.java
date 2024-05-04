package com.att.tdp.bisbis10;


import com.att.tdp.bisbis10.entitys.Cuisine;
import com.att.tdp.bisbis10.entitys.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class RestaurantConfig {

    @Bean
    CommandLineRunner addingRestaurant(RestaurantRepository restaurantRepository)
    {

            return args -> {
                if (restaurantRepository.findAll().size()==0) {
                    Restaurant japanika = new Restaurant("Japanika", true, Set.of(Cuisine.ASIAN));
                    Restaurant taizu = new Restaurant("Taizu", false,
                            Set.of(Cuisine.ASIAN, Cuisine.MEXICAN, Cuisine.INDIAN));
                    restaurantRepository.saveAll(List.of(japanika, taizu));
                }
            };
    }
}
