package com.example.southtech.menu.planning.menuplanning.web.controller;

import com.example.southtech.menu.planning.common.constants.AccessApiConstant;
import com.example.southtech.menu.planning.menuplanning.constants.CustomerReviewConstant;
import com.example.southtech.menu.planning.menuplanning.service.CustomerService;
import com.example.southtech.menu.planning.menuplanning.service.RecipeService;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.CustomerReviewRequest;
import com.example.southtech.menu.planning.menuplanning.web.dto.request.RecipeRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(AccessApiConstant.PRIVATE + CustomerReviewConstant.REVIEW)
public class CustomerReviewController {

    public final CustomerService customerService;

    @PostMapping("/create/review")
    public ResponseEntity<String> createCustomerReview(@RequestBody CustomerReviewRequest customerReviewRequest) {
        return new ResponseEntity(customerService.createCustomerReview(customerReviewRequest), HttpStatus.CREATED);
    }


}
