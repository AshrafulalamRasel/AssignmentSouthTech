package com.example.southtech.menu.planning;

import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.service.RecipeService;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.ArgumentCaptor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


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
}
