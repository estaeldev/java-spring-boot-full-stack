package com.in28minutes.rest.webservices.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.infrastructure.entity.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity, UUID> {
    
}
