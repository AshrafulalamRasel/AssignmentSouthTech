package com.example.southtech.menu.planning.menuplanning.service;

import com.example.southtech.menu.planning.common.exceptions.ResourceNotFoundException;
import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.model.repository.WeekMenuRepository;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.WeekMenuRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.WeekMenuResponse;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.WeekMenuResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class WeekMenuService {

    public final WeekMenuRepository weekMenuRepository;
    public final RecipeRepository recipeRepository;


    public String createWeekMenu(WeekMenuRequest weekMenuRequest) {

        WeeklyMenu weeklyMenu = new WeeklyMenu();

        BeanUtils.copyProperties(weekMenuRequest, weeklyMenu);
        List<Recipe> recipeList = new ArrayList<>();
        weekMenuRequest.getRecipeIdList().forEach(res -> {
            Optional<Recipe> recipeOptional = recipeRepository.findById(res);
            recipeList.add(recipeOptional.get());
        });
        weeklyMenu.setRecipeList(recipeList);

        weekMenuRepository.saveAndFlush(weeklyMenu);

        return "Successfully Save";
    }


    public WeekMenuResponse getAllWeekMenu(int PageNo) {

        Pageable pageable = PageRequest.of(PageNo,5);

        Page<WeeklyMenu> weeklyMenuList = weekMenuRepository.findAll(pageable);

            int page = weeklyMenuList.getNumber();
            int size = weeklyMenuList.getSize();
            int totalPage = weeklyMenuList.getTotalPages();
            long totalElement = weeklyMenuList.getTotalElements();


        List<WeekMenuResponseDto> weekMenuResponseList = new ArrayList<>();

        weeklyMenuList.forEach(weeklyMenu -> {
            weekMenuResponseList.add(new WeekMenuResponseDto(weeklyMenu.getWeekName(), weeklyMenu.getDescription(),
                    weeklyMenu.getRecipeList()));
        });

        return WeekMenuResponse.builder()
                .page(page)
                .size(size)
                .totalPages(totalPage)
                .totalElements(totalElement)
                .items(weekMenuResponseList)
                .build();
    }

    public WeekMenuResponseDto getWeekMenuById(Long id) {

        Optional<WeeklyMenu> weeklyMenuOptional = weekMenuRepository.findById(id);

        if (!weeklyMenuOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found Weekly Menu!!");
        }

        WeeklyMenu weeklyMenu = weeklyMenuOptional.get();

        return WeekMenuResponseDto.builder()
                .weekName(weeklyMenu.getWeekName())
                .description(weeklyMenu.getDescription())
                .recipeList(weeklyMenu.getRecipeList())
                .build();
    }

    public String updateWeeklyMenuById(Long id, Long recipeId, WeekMenuResponseDto weekMenuResponse) {

        Optional<WeeklyMenu> weeklyMenuOptional = weekMenuRepository.findById(id);


        if (!weeklyMenuOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found Weekly Menu!!");
        }

        WeeklyMenu weeklyMenu = weeklyMenuOptional.get();


        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        Recipe recipe = recipeOptional.get();

        weekMenuResponse.getRecipeList().forEach(requestDataRecipe -> {

            recipe.setRecipeName(requestDataRecipe.getRecipeName());
            recipe.setRecipeIngredients(requestDataRecipe.getRecipeIngredients());
            recipe.setRecipeInstruction(requestDataRecipe.getRecipeInstruction());
            recipe.setNutritionalInformation(requestDataRecipe.getNutritionalInformation());
            recipe.setClassification(requestDataRecipe.getClassification());
            recipeRepository.save(recipe);
        });


        weeklyMenu.setWeekName(weekMenuResponse.getWeekName());
        weeklyMenu.setDescription(weekMenuResponse.getDescription());
        weekMenuRepository.save(weeklyMenu);
        return "Successfully Update";

    }

    public String deleteWeeklyMenuById(Long id) {
        weekMenuRepository.deleteById(id);
        return "Successfully Delete";
    }


}
