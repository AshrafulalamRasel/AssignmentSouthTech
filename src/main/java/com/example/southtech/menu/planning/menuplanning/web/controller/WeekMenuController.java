package com.example.southtech.menu.planning.menuplanning.web.controller;

import com.example.southtech.menu.planning.common.constants.AccessApiConstant;
import com.example.southtech.menu.planning.menuplanning.constants.WeeklyMenuConstant;
import com.example.southtech.menu.planning.menuplanning.service.WeekMenuService;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.WeekMenuRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.WeekMenuResponse;
import com.example.southtech.menu.planning.menuplanning.web.dto.response.WeekMenuResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(AccessApiConstant.PRIVATE + WeeklyMenuConstant.WEEKLY_MENU)
public class WeekMenuController {

    public final WeekMenuService weekMenuService;

    @PostMapping("/create")
    public ResponseEntity<String> createWeeklyMenu(@RequestBody WeekMenuRequest weekMenuRequest){
        return new ResponseEntity(weekMenuService.createWeekMenu(weekMenuRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll/{pageNo}")
    public ResponseEntity<WeekMenuResponse> getAllWeeklyMenu(@PathVariable int pageNo){
        return new ResponseEntity(weekMenuService.getAllWeekMenu(pageNo),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeekMenuResponseDto> getAllWeeklyMenuBy(@PathVariable Long id){
        return new ResponseEntity(weekMenuService.getWeekMenuById(id),HttpStatus.OK);
    }

    @PutMapping("/updateBy/{id}/recipeBy/{recipeId}")
    public ResponseEntity<String> updateWeeklyMenu(@PathVariable Long id,@PathVariable Long recipeId,@RequestBody WeekMenuResponseDto weekMenuResponseDto){

               return new ResponseEntity(weekMenuService.updateWeeklyMenuById(id,recipeId,weekMenuResponseDto),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteBy/{id}")
    public  ResponseEntity<String> deleteByWeeklyMenu(@PathVariable Long id){
        return new ResponseEntity(weekMenuService.deleteWeeklyMenuById(id),HttpStatus.NOT_FOUND);
    }

}
