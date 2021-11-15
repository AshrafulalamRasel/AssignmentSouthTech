package com.example.southtech.menu.planning.menuplanning.web.dto.response;

import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RecipeResponse {

    private String recipeName;

    private String recipeIngredients;

    private String recipeInstruction;

    private String nutritionalInformation;

    private String classification;

}
