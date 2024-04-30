package com.att.tdp.bisbis10.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.testutils.RestaurantTestUtils;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTests {
    

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private List<Restaurant> mockRestaurants;
    private Restaurant mockRestaurant;

    @BeforeEach
    void setUp() {
        // Warning! - Changing this value might cause problems in some tests!
        int RESTAURANTS_COUNT = 10;

        mockRestaurants = RestaurantTestUtils.createRandomRestaurantList(RESTAURANTS_COUNT);
        mockRestaurant = new Restaurant(
            "Crazy Hareef Falafel", 
            true, 
            Set.of("Israeli", "Egyption")
        );

        mockRestaurants.add(mockRestaurant);
        for(int i = 0; i < 3 && i < RESTAURANTS_COUNT; ++i) {
            mockRestaurants.get(i)
                .getCuisines()
                .add("Test1");
        }
        for(int i = 0; i < 7 && i < RESTAURANTS_COUNT; ++i) {
            Restaurant restaurant = mockRestaurants.get(i);
            restaurant.getCuisines().add("Test2");
        }
    }

    @Test
    void testGetRestaurants_NoPagination() {
        when(restaurantRepository.findAll()).thenReturn(mockRestaurants);

        List<Restaurant> result = restaurantService.getRestaurants(null, null);

        assertEquals(mockRestaurants, result);
    }

    @Test
    void testGetRestaurants_WithPagination() {
        Page<Restaurant> mockPage = new PageImpl<>(mockRestaurants);
        when(restaurantRepository.findAll(PageRequest.of(0, 10))).thenReturn(mockPage);

        List<Restaurant> result = restaurantService.getRestaurants(0, 10);

        assertEquals(mockRestaurants, result);
    }

    @Test
    void testGetRestaurantsByCuisine_NoPagination() {
        List<Restaurant> expected1 = mockRestaurants.subList(0, 3);
        List<Restaurant> expected2 = mockRestaurants.subList(0, 7);
        List<Restaurant> expected3 = new ArrayList<>();

        when(restaurantRepository.findByCuisinesContaining("Test1")).thenReturn(expected1);
        when(restaurantRepository.findByCuisinesContaining("Test2")).thenReturn(expected2);
        when(restaurantRepository.findByCuisinesContaining("BadCuisine")).thenReturn(expected3);

        List<Restaurant> result1 = restaurantService.getRestaurantsByCuisine("Test1", null, null);
        List<Restaurant> result2 = restaurantService.getRestaurantsByCuisine("Test2", null, null);
        List<Restaurant> result3 = restaurantService.getRestaurantsByCuisine("BadCuisine", null, null);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }

    @Test
    @Disabled
    void testGetRestaurantsByCuisine_WithPagination() {
        Page<Restaurant> mockPage = new PageImpl<>(mockRestaurants);
        when(restaurantRepository.findAll(PageRequest.of(0, 10))).thenReturn(mockPage);

        List<Restaurant> result1 = restaurantService.getRestaurantsByCuisine("Test1", null, null);
        List<Restaurant> result2 = restaurantService.getRestaurantsByCuisine("Test2", null, null);
        List<Restaurant> result3 = restaurantService.getRestaurantsByCuisine("BadCuisine", null, null);

        assertEquals(mockRestaurants, result1);
    }

}
