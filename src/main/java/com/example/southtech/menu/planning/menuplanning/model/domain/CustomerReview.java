package com.example.southtech.menu.planning.menuplanning.model.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMER_REVIEW")
public class CustomerReview extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String command;

    private int rating;

    @ManyToOne
    private WeeklyMenu weeklyMenu;

    @ManyToOne
    private Recipe recipe;
}
