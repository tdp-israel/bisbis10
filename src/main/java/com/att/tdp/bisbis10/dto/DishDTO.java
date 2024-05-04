package com.att.tdp.bisbis10.dto;

public record DishDTO(Long id,
                      String name,
                      String description,
                      Integer price,
                      Long restId) {}
