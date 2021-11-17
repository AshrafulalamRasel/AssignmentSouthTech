package com.example.southtech.menu.planning.menuplanning.web.controller;

import com.example.southtech.menu.planning.common.constants.AccessApiConstant;
import com.example.southtech.menu.planning.menuplanning.constants.RecipeConstant;
import com.example.southtech.menu.planning.menuplanning.constants.WeeklyMenuConstant;
import com.example.southtech.menu.planning.menuplanning.service.RecipeService;
import com.example.southtech.menu.planning.menuplanning.service.WeekMenuService;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.WeekMenuRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponse;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.RecipeResponseDto;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.WeekMenuResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(AccessApiConstant.PRIVATE + RecipeConstant.RECIPE)
public class RecipeController {

    public final RecipeService recipeService;

    @PostMapping("/create")
    public ResponseEntity<String> createRecipe(@RequestBody RecipeRequest recipeRequest){
        return new ResponseEntity(recipeService.createRecipe(recipeRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll/{pageNo}")
    public ResponseEntity<WeekMenuResponse> getAllRecipe(@PathVariable int pageNo){
        return new ResponseEntity(recipeService.getAllRecipe(pageNo),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> getAllRecipe(@PathVariable Long id){
        return new ResponseEntity(recipeService.getRecipeById(id),HttpStatus.OK);
    }

    @PutMapping("/updateBy/{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable Long id,@RequestBody RecipeResponseDto recipeResponse){

               return new ResponseEntity(recipeService.updateRecipeById(id,recipeResponse),HttpStatus.NO_CONTENT);
    }



}
