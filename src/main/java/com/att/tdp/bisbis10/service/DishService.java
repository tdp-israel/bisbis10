package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    DishRepository repository;

    @Autowired
    RestaurantService restService;

    public Dish addDish(Long restId, DishDTO dishDTO){
        Optional<Restaurant> optionalRest = restService.getRestaurantById(restId);
        if(optionalRest.isPresent()){
            Restaurant rest = optionalRest.get();
            List<Dish> dishes = rest.getDishes();
            if(dishes.stream().map(Dish::getName).anyMatch(dishName->dishName==dishDTO.name())) return null;
            Dish toCreate = new Dish(dishDTO.name(), dishDTO.description(), dishDTO.price(), rest);
            repository.save(toCreate);
            return toCreate;

        }
        return null;
    }

    public Dish updateDish(Long dishId, DishDTO newDish){
        Dish toUpdate = getDishById(dishId).orElse(null);
        if(toUpdate==null) return null;
        if(newDish.description()!= null) toUpdate.setDescription(newDish.description());
        if(newDish.name() != null) toUpdate.setName(newDish.name());
        if(newDish.price() == null || newDish.price()<0) throw new IllegalArgumentException("Price cannot be negative");
        toUpdate.setPrice(newDish.price());
        return repository.save(toUpdate);

    }

    public Optional<Dish> getDishById(Long id){
        return repository.findById(id);
    }


    public void deleteDish(Long dishId) {
        repository.deleteById(dishId);
    }

    public List<Dish> getDishesByRestaurantId(Long id) {
        Optional<Restaurant> rest = restService.getRestaurantById(id);
        if(!rest.isPresent()){
            return null;
        }
        Restaurant restaurant = rest.get();
        return restaurant.getDishes();


    }
}
