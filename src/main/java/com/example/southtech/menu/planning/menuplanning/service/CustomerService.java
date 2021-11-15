package com.example.southtech.menu.planning.menuplanning.service;

import com.example.southtech.menu.planning.menuplanning.model.domain.CustomerReview;
import com.example.southtech.menu.planning.menuplanning.model.domain.Recipe;
import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import com.example.southtech.menu.planning.menuplanning.model.repository.CustomerReviewRepository;
import com.example.southtech.menu.planning.menuplanning.model.repository.RecipeRepository;
import com.example.southtech.menu.planning.menuplanning.model.repository.WeekMenuRepository;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.CustomerReviewRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerReviewRepository customerReviewRepository;
    public final WeekMenuRepository weekMenuRepository;
    public final RecipeRepository recipeRepository;

    public String createCustomerReview(CustomerReviewRequest customerReviewRequest) {

        CustomerReview customerReview = new CustomerReview();

        BeanUtils.copyProperties(customerReviewRequest, customerReview);

        Optional<WeeklyMenu> weeklyMenuOptional = weekMenuRepository.findById(customerReviewRequest.getWeeklyMenuId());
        Optional<Recipe> recipe = recipeRepository.findById(customerReviewRequest.getRecipeId());
        customerReview.setCommand(customerReviewRequest.getCommand());
        customerReview.setRating(customerReviewRequest.getRating());
        customerReview.setWeeklyMenu(weeklyMenuOptional.get());
        customerReview.setRecipe(recipe.get());

        customerReviewRepository.saveAndFlush(customerReview);

        return "Successfully Save";
    }

}
