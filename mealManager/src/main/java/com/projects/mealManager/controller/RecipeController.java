package com.projects.mealManager.controller;

import com.projects.mealManager.entity.Recipe;
import com.projects.mealManager.service.IngredientService;
import com.projects.mealManager.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.projects.mealManager.constant.Constant.COVER_DIRECTORY;
import static org.springframework.util.MimeTypeUtils.IMAGE_JPEG_VALUE;
import static org.springframework.util.MimeTypeUtils.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
@Slf4j
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        return ResponseEntity.created(URI.create("/recipes/recipeID")).body(recipeService.createRecipe(recipe));
    }

    @GetMapping
    public ResponseEntity<Page<Recipe>> getRecipes(@RequestParam(value="page", defaultValue= "0") int page,
                                               @RequestParam(value="size", defaultValue = "10") int size){
        return ResponseEntity.ok().body(recipeService.getAllRecipes(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipes(@PathVariable(value="id") String id){
        return ResponseEntity.ok().body(recipeService.getRecipe(id));
    }

    @PutMapping("/photo")
    public ResponseEntity<String> uploadPhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile file){
        return ResponseEntity.ok().body(recipeService.uploadPhoto(id, file));
    }

    @GetMapping(path="/image/{filename}", produces = { IMAGE_PNG_VALUE, IMAGE_JPEG_VALUE })
    public byte[] getPhoto(@PathVariable("filename") String filename) throws IOException {
        return Files.readAllBytes(Paths.get(COVER_DIRECTORY + filename));
    }
}
