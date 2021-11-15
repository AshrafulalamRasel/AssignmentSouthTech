package com.example.southtech.menu.planning.menuplanning.web.dto.request;


import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
public class RecipeRequest {

    private String recipeName;

    private String recipeIngredients;

    private String recipeInstruction;

    private String nutritionalInformation;

    private String classification;


}
