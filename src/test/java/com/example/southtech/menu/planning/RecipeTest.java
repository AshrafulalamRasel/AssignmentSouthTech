package com.example.southtech.menu.planning;

import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.service.RecipeService;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponseDto;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeTest {
    public final RecipeRepository mockRecipeRepository;
    public final RecipeService recipeService;

    public RecipeTest(RecipeRepository mockRecipeRepository, RecipeService recipeService) {
        this.mockRecipeRepository = mockRecipeRepository;
        this.recipeService = recipeService;
    }


    @Test
    public void shouldCreateCalendarWhenRequestIsValid() {

        // Given
        ArgumentCaptor<Recipe> recipeArgumentCaptor = ArgumentCaptor.forClass(Recipe.class);
        //when().thenReturn("Successfully Save");

        RecipeRequest request = new RecipeRequest();

        request.setRecipeName("RecipeName");
        request.setRecipeIngredients("RecipeIngredients");
        request.setRecipeInstruction("RecipeInstruction");
        request.setNutritionalInformation("NutritionalInformation");
        request.setClassification("Classification");


        // When
        recipeService.createRecipe(request);


        // Then
        assertEquals("Successfully Save", "Successfully Save");
        verify(mockRecipeRepository).saveAndFlush(recipeArgumentCaptor.capture());

        assertEquals("RecipeName", recipeArgumentCaptor.getValue().getRecipeName());
        assertEquals("RecipeIngredients", recipeArgumentCaptor.getValue().getRecipeIngredients());
        assertEquals("RecipeInstruction", recipeArgumentCaptor.getValue().getRecipeInstruction());
        assertEquals("NutritionalInformation", recipeArgumentCaptor.getValue().getNutritionalInformation());
        assertEquals("Classification", recipeArgumentCaptor.getValue().getClassification());

    }

    @Test
    public void shouldGetRecipeWhenRecipeFoundById() {

        // Given
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setRecipeName("recipeName");
        recipe.setRecipeIngredients("recipeIn");
        recipe.setRecipeInstruction("recipeInstruction");
        recipe.setNutritionalInformation("recipeInfo");
        recipe.setClassification("recipeClass");

        when(mockRecipeRepository.findById(1L)).thenReturn(Optional.ofNullable(recipe));

        // When
        RecipeResponseDto recipeResponseDto = recipeService.getRecipeById(1L);

        // Then
        assertEquals("recipeName", recipeResponseDto.getRecipeName());
        assertEquals("recipeIn", recipeResponseDto.getRecipeIngredients());
        assertEquals("recipeInstruction", recipeResponseDto.getRecipeInstruction());
        assertEquals("recipeInfo", recipeResponseDto.getNutritionalInformation());
        assertEquals("recipeClass", recipeResponseDto.getClassification());

    }
}
