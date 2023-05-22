package com.Geekster.Recipe.Management.System.API.controller;

import com.Geekster.Recipe.Management.System.API.model.Comment;
import com.Geekster.Recipe.Management.System.API.model.Recipe;
import com.Geekster.Recipe.Management.System.API.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @PostMapping("/post/recipe")
    public ResponseEntity<String> createRecipe(@Valid @RequestBody Recipe recipe) {
        List<Comment> commentList = recipe.getCommentList();
        for(Comment comment :  commentList){
            comment.setRecipe(recipe);
        }
        recipeService.createRecipe(recipe);
        return new ResponseEntity<String>("successfully added", HttpStatus.CREATED);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @Valid @RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(id, recipe);
        return ResponseEntity.ok(updatedRecipe);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }
    @GetMapping("recipe/by/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        return ResponseEntity.ok(recipe);
    }
}
