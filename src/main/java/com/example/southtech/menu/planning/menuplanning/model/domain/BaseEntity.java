package com.example.southtech.menu.planning.menuplanning.model.domain;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private String createdBy;

    private String updatedBy;

    @PrePersist
    public void onCreate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        setCreatedBy(auth.getName());
    }

    @PreUpdate
    public void onUpdate() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        setUpdatedBy(auth.getName());
    }
}
