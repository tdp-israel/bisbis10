package com.att.tdp.bisbis10.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@DirtiesContext
public class RestaurantControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetRestaurants_NoPagination() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$")).isArray())
               .andExpect(MockMvcResultMatchers.jsonPath(("$.length()")).value(100));
    }

    @Test
    public void testGetRestaurants_ByCuisine_NoPagination() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
               .param("cuisine", "Chinese"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$")).isArray())
               .andExpect(MockMvcResultMatchers.jsonPath(("$.length()")).value(30));
    }

    @Test
    public void testGetRestaurants_ByCuisine_WithPagination() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants")
               .param("cuisine", "Chinese")
               .param("page", "1")
               .param("pageSize", "25"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath(("$")).isArray())
               .andExpect(MockMvcResultMatchers.jsonPath(("$.length()")).value(5));
    }

    @Test
    public void testGetRestaurant_ById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/1", 1))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // TODO - investigate
    // This test does not work alone!
    // @Test
    // @Disabled
    // @Rollback
    // public void testAddRestaurant() throws Exception {
    //     String restaurant = "{" +
    //                 "    \"name\": \"A Created Restaurant\"," +
    //                 "    \"isKosher\": true," +
    //                 "    \"cuisines\": [" +
    //                 "        \"Asian\"," +
    //                 "        \"Mexican\"" +
    //                 "    ]" +
    //                 "}";
    //     mockMvc.perform(MockMvcRequestBuilders.post("/restaurants")
    //            .content(restaurant)
    //            .contentType("application/json"))
    //            .andExpect(MockMvcResultMatchers.status().isCreated());
    // }

    @Test
    public void testUpdateRestaurant() throws Exception {
        String restaurant = "{" +
        "    \"cuisines\": [" +
        "        \"Asian\"" +
        "    ]" +
        "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/restaurants/100", 1)
               .content(restaurant)
               .contentType("application/json"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback
    public void testDeleteRestaurant() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/restaurants/100", 1))
               .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
