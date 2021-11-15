package com.example.southtech.menu.planning.menuplanning.service;

import com.example.southtech.menu.planning.common.exceptions.ResourceNotFoundException;
import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class RecipeService {

    public final RecipeRepository recipeRepository;


    public String createRecipe(RecipeRequest recipeRequest) {

        Recipe recipe = new Recipe();

        BeanUtils.copyProperties(recipeRequest, recipe);

        recipeRepository.saveAndFlush(recipe);

        return "Successfully Save";
    }


    public List<RecipeResponse> getAllRecipe() {

        List<Recipe> recipeList = recipeRepository.findAll();

        List<RecipeResponse> recipeResponseArrayList = new ArrayList<>();

        recipeList.forEach(recipe -> {
            recipeResponseArrayList.add(new RecipeResponse(
                    recipe.getRecipeName(), recipe.getRecipeIngredients(),
                    recipe.getRecipeInstruction(), recipe.getNutritionalInformation(),
                    recipe.getClassification()));
        });

        return recipeResponseArrayList;
    }

    public RecipeResponse getRecipeById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found Recipe !!");
        }

        Recipe recipe = recipeOptional.get();

        return RecipeResponse.builder()
                .recipeName(recipe.getRecipeName())
                .recipeIngredients(recipe.getRecipeIngredients())
                .recipeInstruction(recipe.getRecipeInstruction())
                .nutritionalInformation(recipe.getNutritionalInformation())
                .classification(recipe.getClassification())
                .build();
    }

    public String updateRecipeById(Long id, RecipeResponse recipeResponse) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found Recipe !!");
        }

        Recipe recipe = recipeOptional.get();
        recipe.setRecipeName(recipeResponse.getRecipeName());
        recipe.setRecipeIngredients(recipeResponse.getRecipeIngredients());
        recipe.setRecipeInstruction(recipeResponse.getRecipeInstruction());
        recipe.setNutritionalInformation(recipeResponse.getNutritionalInformation());
        recipe.setClassification(recipeResponse.getClassification());

        recipeRepository.save(recipe);
        return "Successfully Update";

    }


}
