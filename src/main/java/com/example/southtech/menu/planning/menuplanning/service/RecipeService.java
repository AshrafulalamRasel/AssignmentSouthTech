package com.example.southtech.menu.planning.menuplanning.service;

import com.example.southtech.menu.planning.common.exceptions.ResourceNotFoundException;
import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponse;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    public RecipeResponse getAllRecipe(int pageNo) {

        List<RecipeResponseDto> recipeResponseArrayList = new ArrayList<>();

        Pageable pageable = PageRequest.of(pageNo, 5);

        Page<Recipe> recipeList = recipeRepository.findAll(pageable);

        int page = recipeList.getNumber();
        int size = recipeList.getSize();
        int totalPage = recipeList.getTotalPages();
        long totalElement = recipeList.getTotalElements();

        recipeList.forEach(recipe -> {
            recipeResponseArrayList.add(new RecipeResponseDto(
                   recipe.getId(), recipe.getRecipeName(), recipe.getRecipeIngredients(),
                    recipe.getRecipeInstruction(), recipe.getNutritionalInformation(),
                    recipe.getClassification()));
        });

        return RecipeResponse.builder()
                .page(page)
                .size(size)
                .totalPages(totalPage)
                .totalElements(totalElement)
                .items(recipeResponseArrayList)
                .build();
    }

    public RecipeResponseDto getRecipeById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found Recipe !!");
        }

        Recipe recipe = recipeOptional.get();

        return RecipeResponseDto.builder()
                .recipeName(recipe.getRecipeName())
                .recipeIngredients(recipe.getRecipeIngredients())
                .recipeInstruction(recipe.getRecipeInstruction())
                .nutritionalInformation(recipe.getNutritionalInformation())
                .classification(recipe.getClassification())
                .build();
    }

    public String updateRecipeById(Long id, RecipeResponseDto recipeResponse) {

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
