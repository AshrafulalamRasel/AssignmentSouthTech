package com.example.southtech.menu.planning.menuplanning.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RECIPE_DB")
public class Recipe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "recipeName", nullable = false)
    private String recipeName;

    @Column(name = "recipeIngredient", nullable = false)
    private String recipeIngredients;

    @Column(name = "recipeInstruction", nullable = false)
    private String recipeInstruction;

    @Column(name = "nutritionalInformation", nullable = false)
    private String nutritionalInformation;

    @Column(name = "classification", nullable = false)
    private String classification;

}
