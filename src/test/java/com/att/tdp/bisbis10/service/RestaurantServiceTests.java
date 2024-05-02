package com.att.tdp.bisbis10.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.exception.restaurant.RestaurantNotFoundException;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import com.att.tdp.bisbis10.testutils.RestaurantTestUtils;

@ExtendWith(MockitoExtension.class)
@DirtiesContext
public class RestaurantServiceTests {
    

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private List<Restaurant> mockRestaurants;
    private Restaurant mockRestaurant;
    // Changing these values can cause some tests to fail
    private final int RESTAURANTS_COUNT = 20;
    private final int TEST_CUIZINE_COUNT1 = Math.min(3, RESTAURANTS_COUNT);
    private final int TEST_CUIZINE_COUNT2 = Math.min(7, RESTAURANTS_COUNT);

    @BeforeEach
    void setUp() {
        mockRestaurants = RestaurantTestUtils.createRandomRestaurantList(RESTAURANTS_COUNT);
        mockRestaurant = new Restaurant(
            "Crazy Hareef Falafel", 
            true, 
            Set.of("Israeli", "Egyption")
        );

        mockRestaurants.add(mockRestaurant);
        for(int i = 0; i < TEST_CUIZINE_COUNT1 && i < RESTAURANTS_COUNT; ++i) {
            mockRestaurants.get(i)
                .getCuisines()
                .add("Test1");
        }
        for(int i = 0; i < TEST_CUIZINE_COUNT2 && i < RESTAURANTS_COUNT; ++i) {
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
        int PAGE1 = 0;
        int PAGE_SIZE1 = 10;
        int PAGE2 = 3;
        int PAGE_SIZE2 = 6;

        List<Restaurant> expected1 = mockRestaurants.subList(0, 10);
        List<Restaurant> expected2 = mockRestaurants.subList(18, 20);

        Page<Restaurant> mockPage1 = new PageImpl<>(expected1);
        Page<Restaurant> mockPage2 = new PageImpl<>(expected2);
        
        when(restaurantRepository.findAll(PageRequest.of(PAGE1, PAGE_SIZE1))).thenReturn(mockPage1);
        when(restaurantRepository.findAll(PageRequest.of(PAGE2, PAGE_SIZE2))).thenReturn(mockPage2);

        List<Restaurant> result1 = restaurantService.getRestaurants(PAGE1, PAGE_SIZE1);
        List<Restaurant> result2 = restaurantService.getRestaurants(PAGE2, PAGE_SIZE2);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
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
    void testGetRestaurantsByCuisine_WithPagination() {
        int PAGE1 = 0;
        int PAGE_SIZE1 = 10;
        int PAGE2 = 1;
        int PAGE_SIZE2 = 2;

        // TODO - use pagination utils to calculate find the sublists instead of writing values by hand
        List<Restaurant> expected1 = mockRestaurants.subList(0, 3);
        List<Restaurant> expected2 = mockRestaurants.subList(0, 7);
        List<Restaurant> expected3 = new ArrayList<>();
        List<Restaurant> expected4 = mockRestaurants.subList(2, 3);
        List<Restaurant> expected5 = mockRestaurants.subList(2, 4);
        List<Restaurant> expected6 = new ArrayList<>();

        Page<Restaurant> mockPage1 = new PageImpl<>(expected1);
        Page<Restaurant> mockPage2 = new PageImpl<>(expected2);
        Page<Restaurant> mockPage3 = new PageImpl<>(expected3);
        Page<Restaurant> mockPage4 = new PageImpl<>(expected4);
        Page<Restaurant> mockPage5 = new PageImpl<>(expected5);
        Page<Restaurant> mockPage6 = new PageImpl<>(expected6);

        when(restaurantRepository.findByCuisinesContaining("Test1", PageRequest.of(PAGE1, PAGE_SIZE1))).thenReturn(mockPage1);
        when(restaurantRepository.findByCuisinesContaining("Test2", PageRequest.of(PAGE1, PAGE_SIZE1))).thenReturn(mockPage2);
        when(restaurantRepository.findByCuisinesContaining("BadCuisine", PageRequest.of(PAGE1, PAGE_SIZE1))).thenReturn(mockPage3);
        when(restaurantRepository.findByCuisinesContaining("Test1", PageRequest.of(PAGE2, PAGE_SIZE2))).thenReturn(mockPage4);
        when(restaurantRepository.findByCuisinesContaining("Test2", PageRequest.of(PAGE2, PAGE_SIZE2))).thenReturn(mockPage5);
        when(restaurantRepository.findByCuisinesContaining("BadCuisine", PageRequest.of(PAGE2, PAGE_SIZE2))).thenReturn(mockPage6);


        List<Restaurant> result1 = restaurantService.getRestaurantsByCuisine("Test1", PAGE1, PAGE_SIZE1);
        List<Restaurant> result2 = restaurantService.getRestaurantsByCuisine("Test2", PAGE1, PAGE_SIZE1);
        List<Restaurant> result3 = restaurantService.getRestaurantsByCuisine("BadCuisine", PAGE1, PAGE_SIZE1);
        List<Restaurant> result4 = restaurantService.getRestaurantsByCuisine("Test1", PAGE2, PAGE_SIZE2);
        List<Restaurant> result5 = restaurantService.getRestaurantsByCuisine("Test2", PAGE2, PAGE_SIZE2);
        List<Restaurant> result6 = restaurantService.getRestaurantsByCuisine("BadCuisine", PAGE2, PAGE_SIZE2);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
        assertEquals(expected5, result5);
        assertEquals(expected6, result6);
    }

    @Test
    void testDeleteRestaurant_ExistingId() {
        int restaurantId = 1;
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(mockRestaurant));

        assertDoesNotThrow(() -> restaurantService.deleteRestaurant(restaurantId));
    }

    @Test
    void testDeleteRestaurant_NonExistingId() {
        int restaurantId = 100;
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> restaurantService.deleteRestaurant(restaurantId));
    }
}
