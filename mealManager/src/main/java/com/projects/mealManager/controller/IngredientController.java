package com.projects.mealManager.controller;

import com.projects.mealManager.entity.Ingredient;
import com.projects.mealManager.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient){
        return ResponseEntity.created(URI.create("/ingredients/ingredientID")).body(ingredientService.addIngredient(ingredient));
    }

    @GetMapping
    public ResponseEntity<Page<Ingredient>> getIngredients(@RequestParam(value="page", defaultValue= "0") int page,
                                                          @RequestParam(value="size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(ingredientService.getAllIngredients(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(ingredientService.getIngredient(id));
    }

}
