package com.example.southtech.menu.planning.menuplanning.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RecipeResponseDto {

    private String recipeName;

    private String recipeIngredients;

    private String recipeInstruction;

    private String nutritionalInformation;

    private String classification;
}
