package com.projects.mealManager.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashMap;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Table(name="recipe")
public class Recipe {

    @Id
    @UuidGenerator
    @Column(name="id",unique = true, updatable = false)
    private String id;
    private String title;
    private int preparationTime; // minutes
    private int cookingTime; // minutes
    private String instruction;
    private String photoUrl;
    private HashMap<String, Integer> ingredients; // the name of the ingredient is the key

    @ManyToMany
    @JoinTable(
            name = "mealSet",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    Set<Meal> mealSet;

}
