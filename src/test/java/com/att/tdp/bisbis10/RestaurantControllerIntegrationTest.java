package com.att.tdp.bisbis10;

import com.att.tdp.bisbis10.model.Restaurants;
import com.att.tdp.bisbis10.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        // Clear any existing data or setup required for the tests
    }

    @Test
    void testGetAllRestaurants() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    void testGetRestaurantsByCuisine() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/by-cuisine").param("cuisine", "Indian"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    void testGetRestaurantById() throws Exception {
        Restaurants restaurant = new Restaurants();
        // Set up restaurant data and save it using the service
        restaurantService.addRestaurant(restaurant);

        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/{id}", restaurant.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(restaurant.getId()))
                .andExpect(jsonPath("$.name").value(restaurant.getName()));
    }

    @Test
    void testAddRestaurant() throws Exception {
        Restaurants restaurant = new Restaurants();
        // Set up restaurant data as needed

        mockMvc.perform(MockMvcRequestBuilders.post("/restaurants")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(restaurant)))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateRestaurant() throws Exception {
        Restaurants restaurant = new Restaurants();
        // Set up restaurant data and save it using the service
        restaurantService.addRestaurant(restaurant);

        restaurant.setName("Updated Restaurant Name");

        mockMvc.perform(MockMvcRequestBuilders.put("/restaurants/{id}", restaurant.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(restaurant)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteRestaurant() throws Exception {
        Restaurants restaurant = new Restaurants();
        // Set up restaurant data and save it using the service
        restaurantService.addRestaurant(restaurant);

        mockMvc.perform(MockMvcRequestBuilders.delete("/restaurants/{id}", restaurant.getId()))
                .andExpect(status().isNoContent());
    }

    // Utility method to convert object to JSON string
    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}