package com.projects.mealManager.repository;

import com.projects.mealManager.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, String> {

    Ingredient findByName(String name);
}
