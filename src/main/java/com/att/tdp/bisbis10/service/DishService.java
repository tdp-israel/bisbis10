package com.att.tdp.bisbis10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.att.tdp.bisbis10.dto.DishRequest;
import com.att.tdp.bisbis10.dto.DishUpdateRequest;
import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.exception.dish.DishDoesNotBelongToRestaurantException;
import com.att.tdp.bisbis10.exception.dish.DishNotFoundException;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.util.PaginationUtils;

@Service
public class DishService {
    DishRepository dishRepository;
    RestaurantService restaurantService;

    @Autowired
    public DishService(DishRepository dishRepository, RestaurantService restaurantService) {
        this.dishRepository = dishRepository;
        this.restaurantService = restaurantService;
    }

    public List<Dish> getDishesByRestaurantId(Integer restaurantId, Integer page, Integer pageSize) {
        // Throws exception when restaurant does not exists
        restaurantService.getRestaurantById(restaurantId);
        List<Dish> dishes;
        
        if(page != null | pageSize != null) {
            Pageable pageable = PaginationUtils.createPageable(page, pageSize);
            Page<Dish> dishesPage = dishRepository.getDishesByRestaurantId(restaurantId, pageable);
            dishes = dishesPage.getContent();
        }
        else {
            dishes = dishRepository.getDishesByRestaurantId(restaurantId);
        }

        return dishes; 
    }

    /* This method verifies that the dish belongs to 
      a certain restaurant by restaurantId
    */
    public Dish getDishById(Integer dishId, Integer restaurantId) {
        Optional<Dish> dish = dishRepository.findById(dishId);
        
        if(!dish.isPresent()) {
            throw new DishNotFoundException(dishId);
        }
        if(dish.get().getRestaurant().getId() != restaurantId) {
            throw new DishDoesNotBelongToRestaurantException(dishId, restaurantId);
        }

        return dish.get();
    }

    public Dish addDish(Integer restaurantId, DishRequest dishRequest) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        Dish dish = new Dish(
            restaurant,
            dishRequest.getName(),
            dishRequest.getDescription(),
            dishRequest.getPrice()
        );

        dishRepository.save(dish);
        return dish;
    }

    public void deleteDish(Integer restaurantId, Integer dishId) {
        // Throws exception when restaurant does not exists
        restaurantService.getRestaurantById(restaurantId);

        // Throws exception when dish does not exists
        getDishById(dishId, restaurantId);

        dishRepository.deleteById(dishId);
    }

    public Dish updatedDish(Integer restaurantId, Integer dishId,
                            DishUpdateRequest dishUpdateRequest) {
        
        // Throws exception when restaurant does not exists
        restaurantService.getRestaurantById(restaurantId);

        Dish dish = this.getDishById(dishId, restaurantId);
        
        dish.setDescription(dishUpdateRequest.getDescription());
        dish.setPrice(dishUpdateRequest.getPrice());
        dishRepository.save(dish);
        return dish;
    }

}
