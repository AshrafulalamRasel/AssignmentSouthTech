package com.example.southtech.menu.planning.menuplanning.model.repository;

import com.example.southtech.menu.planning.menuplanning.model.domain.WeeklyMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekMenuRepository extends JpaRepository<WeeklyMenu,Long> {
}
