package com.in28minutes.springboot.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.infrastructure.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
    
    
}
