package com.example.southtech.menu.planning.menuplanning.web.dto.request;


import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeekMenuRequest {

    private String weekName;
    private String description;
    private List<Long> recipeIdList;

}
