package com.projects.mealManager.service;

import com.projects.mealManager.entity.Meal;
import com.projects.mealManager.entity.Recipe;
import com.projects.mealManager.repository.MealRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class MealService {

    @Autowired
    MealRepository mealRepository;
    RecipeService recipeService;

    public Page<Meal> getAllMeals(int page, int size) {
        log.info("Get all the meals");
        return mealRepository.findAll(PageRequest.of(page, size, Sort.by("mealDateTime")));
    }

    public Meal getMeal(String id){
        log.info("Get a meal");
        return mealRepository.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
    }

    public Meal createMeal(Meal meal){
        log.info("Save Meal");
        return mealRepository.save(meal);
    }
}
