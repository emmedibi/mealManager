package com.projects.mealManager.controller;

import com.projects.mealManager.entity.Meal;
import com.projects.mealManager.entity.Recipe;
import com.projects.mealManager.service.MealService;
import com.projects.mealManager.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
@Slf4j
public class MealController {

    @Autowired
    MealService mealService;
    RecipeService recipeService;

    @GetMapping
    public ResponseEntity<Page<Meal>> getMeals(@RequestParam(value="page", defaultValue= "0") int page,
                                                   @RequestParam(value="size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(mealService.getAllMeals(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMeal(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(mealService.getMeal(id));
    }

    @PostMapping
    public ResponseEntity<Meal> addMeal(@RequestParam(value="recipeIds") List<String> recipeIds){
        Meal meal = new Meal();
        try {
            ArrayList<Recipe> recipeList = new ArrayList<>();
            for(String stringIdIterator : recipeIds){
                recipeList.add(recipeService.getRecipe(stringIdIterator));
            }
            meal.setRecipes(recipeList);
            LocalDateTime mealDateTime = LocalDateTime.now();
            meal.setMealDateTime(mealDateTime);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        return ResponseEntity.ok().body(mealService.createMeal(meal));
    }

}
