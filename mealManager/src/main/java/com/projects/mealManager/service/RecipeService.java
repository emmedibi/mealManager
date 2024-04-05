package com.projects.mealManager.service;

import com.projects.mealManager.entity.Recipe;
import com.projects.mealManager.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.projects.mealManager.constant.Constant.COVER_DIRECTORY;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Page<Recipe> getAllRecipes(int page, int size) {
        log.info("Get all the recipes");
        return recipeRepository.findAll(PageRequest.of(page, size, Sort.by("title")));
    }

    public Recipe getRecipe(String id){
        log.info("Get a recipe");
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public Recipe createRecipe(Recipe book){
        log.info("Save Book");
        return recipeRepository.save(book);
    }

    public String uploadPhoto(String id, MultipartFile file){
        Recipe recipe = getRecipe(id);
        String photoUrl = coverFunction.apply(id, file);
        recipe.setPhotoUrl(photoUrl);
        recipeRepository.save(recipe);
        return photoUrl;
    }

    private final Function<String, String> fileExtension = filename -> Optional.of(filename).filter(name -> name.contains("."))
            .map(name -> "." + name.substring(filename.lastIndexOf(".") + 1)).orElse(".png");

    private final BiFunction<String, MultipartFile, String> coverFunction = (id, image) -> {
        String filename = id + fileExtension.apply(image.getOriginalFilename());
        try {
            Path fileStorageLocation = Paths.get(COVER_DIRECTORY).toAbsolutePath().normalize();
            if(!Files.exists(fileStorageLocation)) {
                Files.createDirectories((fileStorageLocation));
            }
            Files.copy(image.getInputStream(), fileStorageLocation.resolve(filename), REPLACE_EXISTING );
            return ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/recipes/image/" + filename).toUriString();
        } catch (Exception exception){
            // generic error message
            throw new RuntimeException("Unable to save the image");
        }
    };
}
