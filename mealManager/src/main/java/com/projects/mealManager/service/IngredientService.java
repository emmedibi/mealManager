package com.projects.mealManager.service;

import com.projects.mealManager.entity.Ingredient;
import com.projects.mealManager.repository.IngredientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Page<Ingredient> getAllIngredients(int page, int size){
        log.info("Get all the ingredients");
        return ingredientRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
        // TO DO: the output should be class Page();
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        log.info("Add ingredient");
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredient(String id) {
        log.info("Get Ingredient by its id");
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    public Ingredient getIngredientByName(String name) {
        log.info("Check if the ingredient exists by its name");
        return ingredientRepository.findByName(name);
    }


}
