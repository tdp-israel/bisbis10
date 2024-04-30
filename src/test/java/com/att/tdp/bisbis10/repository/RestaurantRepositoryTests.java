package com.att.tdp.bisbis10.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.testutils.PaginationTestUtils;
import com.att.tdp.bisbis10.testutils.RestaurantTestUtils;
import com.att.tdp.bisbis10.util.PaginationUtils;

@DataJpaTest
public class RestaurantRepositoryTests {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @AfterEach
    void deleteAll() {
        restaurantRepository.deleteAll();
    }

    @Test
    void itShouldReturnAllRestaurantsWithProperData() {
        int RESTAURANTS_COUNT = 10;
        List<Restaurant> restaurants = RestaurantTestUtils.createRandomRestaurantList(RESTAURANTS_COUNT);

        restaurants.forEach(restaurant -> restaurantRepository.save(restaurant));        

        List<Restaurant> actual = restaurantRepository.findAll();

        // Assert Size
        assertEquals(RESTAURANTS_COUNT, actual.size());
        
        // Assert Data Validity
        for(int i = 0; i < restaurants.size(); ++i) {
            Restaurant restaurant = restaurants.get(i);
            Restaurant expectedRestaurant = actual.get(i);

            assertEquals(restaurant.getName(), expectedRestaurant.getName());
            assertEquals(restaurant.getIsKosher(), expectedRestaurant.getIsKosher());
            assertTrue(restaurant.getCuisines().equals(
                expectedRestaurant.getCuisines()
            ));
            assertEquals(expectedRestaurant.getAverageRating(), 0.0f);
        }
    }

    @Test
    void itShouldReturnRestaurantsByCuisine() {
        int RESTAURANTS_COUNT = 30;
        int RESTAURANTS_WITH_CUISINE_TEST1 = 10;
        int RESTAURANTS_WITH_CUISINE_TEST2 = 2;
        int RESTAURANTS_WITH_CUISINE_TEST3 = 0;
        List<Restaurant> restaurants = RestaurantTestUtils.createRandomRestaurantList(RESTAURANTS_COUNT);

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST1; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Test1");
        }

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST2; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Test2");
        }

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST3; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Tset3");
        }


        restaurants.forEach(restaurant -> restaurantRepository.save(restaurant));        

        List<Restaurant> restaurantsWithCuisineTest1 = restaurantRepository.findByCuisinesContaining("Test1");
        List<Restaurant> restaurantsWithCuisineTest2 = restaurantRepository.findByCuisinesContaining("Test2");
        List<Restaurant> restaurantsWithCuisineTest3 = restaurantRepository.findByCuisinesContaining("Test3");

        // Assert Size
        assertEquals(RESTAURANTS_WITH_CUISINE_TEST1, restaurantsWithCuisineTest1.size());
        assertEquals(RESTAURANTS_WITH_CUISINE_TEST2, restaurantsWithCuisineTest2.size());
        assertEquals(RESTAURANTS_WITH_CUISINE_TEST3, restaurantsWithCuisineTest3.size());
    }

    @Test
    void itShouldReturnRestaurantsPageByCuisine() {
        int RESTAURANTS_COUNT = 30;
        int RESTAURANTS_WITH_CUISINE_TEST1 = 10;
        int RESTAURANTS_WITH_CUISINE_TEST2 = 7;
        int RESTAURANTS_WITH_CUISINE_TEST3 = 0;
        int PAGE1 = 0;
        int PAGE2 = 1;
        int PAGE3 = 1;
        int PAGE1Size1 = 10;
        int PAGE1Size2 = 10;
        int PAGE1Size3 = 5;
        Pageable pageable1 = PaginationUtils.createPageable(PAGE1, PAGE1Size1);
        Pageable pageable2 = PaginationUtils.createPageable(PAGE2, PAGE1Size2);
        Pageable pageable3 = PaginationUtils.createPageable(PAGE3, PAGE1Size3);
        List<Restaurant> restaurants = RestaurantTestUtils.createRandomRestaurantList(RESTAURANTS_COUNT);

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST1; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Test1");
        }

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST2; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Test2");
        }

        for(int i = 0; i < RESTAURANTS_WITH_CUISINE_TEST3; ++i) {
            Set<String> cuisines = restaurants.get(i).getCuisines();
            cuisines.add("Tset3");
        }


        restaurants.forEach(restaurant -> restaurantRepository.save(restaurant));        

        Page<Restaurant> restaurantsWithCuisineTest1Pageable1 = restaurantRepository.findByCuisinesContaining("Test1", pageable1);
        Page<Restaurant> restaurantsWithCuisineTest2Pageable1 = restaurantRepository.findByCuisinesContaining("Test2", pageable1);
        Page<Restaurant> restaurantsWithCuisineTest3Pageable1 = restaurantRepository.findByCuisinesContaining("Test3", pageable1);
        Page<Restaurant> restaurantsWithCuisineTest1Pageable2 = restaurantRepository.findByCuisinesContaining("Test1", pageable2);
        Page<Restaurant> restaurantsWithCuisineTest2Pageable2 = restaurantRepository.findByCuisinesContaining("Test2", pageable2);
        Page<Restaurant> restaurantsWithCuisineTest3Pageable2 = restaurantRepository.findByCuisinesContaining("Test3", pageable2);
        Page<Restaurant> restaurantsWithCuisineTest1Pageable3 = restaurantRepository.findByCuisinesContaining("Test1", pageable3);
        Page<Restaurant> restaurantsWithCuisineTest2Pageable3 = restaurantRepository.findByCuisinesContaining("Test2", pageable3);
        Page<Restaurant> restaurantsWithCuisineTest3Pageable3 = restaurantRepository.findByCuisinesContaining("Test3", pageable3);


        
        int restCuzTest1Pagable1Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST1, PAGE1, PAGE1Size1);
        int restCuzTest2Pagable1Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST2, PAGE1, PAGE1Size1);
        int restCuzTest3Pagable1Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST3, PAGE1, PAGE1Size1);
        int restCuzTest1Pagable2Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST1, PAGE2, PAGE1Size2);
        int restCuzTest2Pagable2Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST2, PAGE2, PAGE1Size2);
        int restCuzTest3Pagable2Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST3, PAGE2, PAGE1Size2);
        int restCuzTest1Pagable3Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST1, PAGE3, PAGE1Size3);
        int restCuzTest2Pagable3Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST2, PAGE3, PAGE1Size3);
        int restCuzTest3Pagable3Size = PaginationTestUtils.calcCountInPage(RESTAURANTS_WITH_CUISINE_TEST3, PAGE3, PAGE1Size3);

        // Assert Size
        assertEquals(restCuzTest1Pagable1Size, restaurantsWithCuisineTest1Pageable1.getNumberOfElements()); 
        assertEquals(restCuzTest2Pagable1Size, restaurantsWithCuisineTest2Pageable1.getNumberOfElements());
        assertEquals(restCuzTest3Pagable1Size, restaurantsWithCuisineTest3Pageable1.getNumberOfElements()); 
        assertEquals(restCuzTest1Pagable2Size, restaurantsWithCuisineTest1Pageable2.getNumberOfElements()); 
        assertEquals(restCuzTest2Pagable2Size, restaurantsWithCuisineTest2Pageable2.getNumberOfElements()); 
        assertEquals(restCuzTest3Pagable2Size, restaurantsWithCuisineTest3Pageable2.getNumberOfElements()); 
        assertEquals(restCuzTest1Pagable3Size, restaurantsWithCuisineTest1Pageable3.getNumberOfElements()); 
        assertEquals(restCuzTest2Pagable3Size, restaurantsWithCuisineTest2Pageable3.getNumberOfElements()); 
        assertEquals(restCuzTest3Pagable3Size, restaurantsWithCuisineTest3Pageable3.getNumberOfElements());
    }
}
