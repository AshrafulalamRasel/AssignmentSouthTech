package com.example.southtech.menu.planning.menuplanning.web.dto.request;


import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import lombok.Builder;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
@Builder
public class CustomerReviewRequest {

    private String command;

    private int rating;

    private Long weeklyMenuId;

    private Long recipeId;


}
