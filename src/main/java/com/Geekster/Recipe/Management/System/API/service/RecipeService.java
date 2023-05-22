package com.Geekster.Recipe.Management.System.API.service;

import com.Geekster.Recipe.Management.System.API.model.Recipe;
import com.Geekster.Recipe.Management.System.API.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    IRecipeRepository iRecipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return iRecipeRepository.save(recipe);
    }
    public Recipe updateRecipe(Long id, Recipe recipe) {
        Recipe existingRecipe = iRecipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
        existingRecipe.setName(recipe.getName());
        existingRecipe.setIngredients(recipe.getIngredients());
        existingRecipe.setInstruction(recipe.getInstruction());
        return iRecipeRepository.save(existingRecipe);
    }
    public void deleteRecipe(Long id) {
        iRecipeRepository.deleteById(id);
    }
    public Recipe getRecipeById(Long id) {
        return iRecipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));
    }
    public List<Recipe> getAllRecipes() {
        return iRecipeRepository.findAll();
    }
}
