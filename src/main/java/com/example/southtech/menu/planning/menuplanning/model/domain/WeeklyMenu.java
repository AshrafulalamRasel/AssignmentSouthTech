package com.example.southtech.menu.planning.menuplanning.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "WEEK_MENU_DB")
public class WeeklyMenu extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "weekname",nullable = false)
    private String weekName;

    @Column(name = "description")
    private String description;

    @OneToMany(targetEntity = Recipe.class,fetch = FetchType.EAGER)
    private List<Recipe> recipeList;
}
