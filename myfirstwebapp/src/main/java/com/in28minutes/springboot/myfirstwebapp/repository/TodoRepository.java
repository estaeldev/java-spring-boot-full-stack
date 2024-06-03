package com.in28minutes.springboot.myfirstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;
import java.util.List;


public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUsername(String username);
    
}
