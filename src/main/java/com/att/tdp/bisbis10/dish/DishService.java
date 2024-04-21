package com.att.tdp.bisbis10.dish;

import org.springframework.beans.factory.annotation.Autowired;

public class DishService {
    DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

}
