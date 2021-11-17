package com.example.southtech.menu.planning.menuplanning.web.dto.response;

import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class WeekMenuResponseDto {

    private Long id;
    private String weekName;
    private String description;
    private List<Recipe> recipeList;
}
