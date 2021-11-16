package com.example.southtech.menu.planning.menuplanning.web.dto.response;

import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class RecipeResponse {

    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<RecipeResponseDto> items;

}
