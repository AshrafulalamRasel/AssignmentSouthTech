package com.example.southtech.menu.planning.menuplanning.model.repository;

import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
}
