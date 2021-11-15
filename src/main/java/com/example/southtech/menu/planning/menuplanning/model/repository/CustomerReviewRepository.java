package com.example.southtech.menu.planning.menuplanning.model.repository;

import com.example.southtech.menu.planning.menuplanning.model.domain.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {
}
