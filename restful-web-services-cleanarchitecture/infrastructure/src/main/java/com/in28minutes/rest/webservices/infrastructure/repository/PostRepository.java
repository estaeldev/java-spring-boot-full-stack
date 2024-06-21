package com.in28minutes.rest.webservices.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.infrastructure.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, UUID> {
    
}
