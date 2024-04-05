package com.projects.mealManager.controller;

import com.projects.mealManager.entity.Meal;
import com.projects.mealManager.entity.Recipe;
import com.projects.mealManager.service.MealService;
import com.projects.mealManager.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/meals")
@RequiredArgsConstructor
public class MealController {

    @Autowired
    MealService mealService;
    RecipeService recipeService;

    @GetMapping
    public ResponseEntity<Page<Recipe>> getRecipes(@RequestParam(value="page", defaultValue= "0") int page,
                                                   @RequestParam(value="size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(recipeService.getAllRecipes(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipes(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(recipeService.getRecipe(id));
    }

}
