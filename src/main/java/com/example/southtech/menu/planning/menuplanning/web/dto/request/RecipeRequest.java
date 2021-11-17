package com.example.southtech.menu.planning.menuplanning.web.dto.request;


import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@NoArgsConstructor
public class RecipeRequest {

    private String recipeName;

    private String recipeIngredients;

    private String recipeInstruction;

    private String nutritionalInformation;

    private String classification;


}
