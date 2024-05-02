package com.att.tdp.bisbis10.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.testutils.PaginationTestUtils;
import com.att.tdp.bisbis10.util.PaginationUtils;

@DataJpaTest
@DirtiesContext
public class RestaurantRepositoryTests {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void itShouldReturnAllRestaurantsWithProperData() {
        List<Restaurant> actual = restaurantRepository.findAll();

        // Assert Size
        assertEquals(100, actual.size());
    }

    @Test
    void itShouldReturnRestaurantsByCuisine() {
        List<Restaurant> restaurantsWithCuisineTest1 = restaurantRepository.findByCuisinesContaining("Chinese");
        List<Restaurant> restaurantsWithCuisineTest2 = restaurantRepository.findByCuisinesContaining("Italian");
        List<Restaurant> restaurantsWithCuisineTest3 = restaurantRepository.findByCuisinesContaining("Indian");

        int expectedSize1 = 30;
        int expectedSize2 = 28;
        int expectedSize3 = 26;
        
        // Assert Size
        assertEquals(expectedSize1, restaurantsWithCuisineTest1.size());
        assertEquals(expectedSize2, restaurantsWithCuisineTest2.size());
        assertEquals(expectedSize3, restaurantsWithCuisineTest3.size());
    }

    @Test
    void itShouldReturnRestaurantsPageByCuisine() {
        int PAGE1 = 0;
        int PAGE1Size1 = 10;
        Pageable pageable1 = PaginationUtils.createPageable(PAGE1, PAGE1Size1);

        int PAGE2 = 2;
        int PAGE1Size2 = 10;
        Pageable pageable2 = PaginationUtils.createPageable(PAGE2, PAGE1Size2);

        Page<Restaurant> restaurants1 = restaurantRepository.findByCuisinesContaining("Italian", pageable1);
        Page<Restaurant> restaurants2 = restaurantRepository.findByCuisinesContaining("Italian", pageable2);


        
        int expectedSize1 = PaginationTestUtils.calcCountInPage(28, PAGE1, PAGE1Size1);
        int expectedSize2 = PaginationTestUtils.calcCountInPage(28, PAGE2, PAGE1Size2);

        // Assert Size
        assertEquals(expectedSize1, restaurants1.getNumberOfElements()); 
        assertEquals(expectedSize2, restaurants2.getNumberOfElements());
    }
}
