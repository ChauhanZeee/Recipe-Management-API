package com.Geekster.Recipe.Management.System.API.repository;

import com.Geekster.Recipe.Management.System.API.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Long> {
}
