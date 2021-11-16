package com.example.southtech.menu.planning.menuplanning.web.dto.response;

import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class WeekMenuResponse {

    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<WeekMenuResponseDto> items;

   /* private String weekName;
    private String description;
    private List<Recipe> recipeList;*/
}
