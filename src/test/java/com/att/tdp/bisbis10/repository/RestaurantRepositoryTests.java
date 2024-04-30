package com.att.tdp.bisbis10.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.att.tdp.bisbis10.entity.Restaurant;

@DataJpaTest
public class RestaurantRepositoryTests {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private List<Restaurant> getRestaurants() {
        return List.of(
            new Restaurant("abc", true, Set.of("a", "b", "c"))
        );
    }

    @Test
    void itShouldReturnAllRestaurants() {
        // init data
        List<Restaurant> restaurants = getRestaurants();

        // save entities
        restaurants.forEach(restaurant -> restaurantRepository.save(restaurant));        

        // Expected
        List<Restaurant> expected = restaurantRepository.findAll();

        // Assert Size
        assertEquals(expected.size(), 1);
        // Assert Data Validity
        for(int i = 0; i < restaurants.size(); ++i) {
            Restaurant restaurant = restaurants.get(i);
            Restaurant expectedRestaurant = expected.get(i);

            assertEquals(restaurant.getName(), expectedRestaurant.getName());
            assertEquals(restaurant.getIsKosher(), expectedRestaurant.getIsKosher());
            assertTrue(restaurant.getCuisines().equals(
                expectedRestaurant.getCuisines()
            ));
            assertEquals(expectedRestaurant.getAverageRating(), 0.0f);
        }
    }

    void itShouldReturnRestaurantsPage() {

    }

    void itShouldReturnAllRestaurantsByCausine() {
        
    }

    void itShouldReturnRestaurantsPageByCausine() {
        
    }

    void itShouldSaveRestaurant() {

    }

    void itShouldReturnRestaurantById() {

    }

    void itShouldDeleteRestaurant() {

    }
}
