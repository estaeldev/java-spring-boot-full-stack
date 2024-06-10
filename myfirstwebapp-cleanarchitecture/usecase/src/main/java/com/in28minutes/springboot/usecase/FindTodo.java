package com.in28minutes.springboot.usecase;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.Todo;

public interface FindTodo {
    
    void find(Todo todo);
    void findById(UUID id);

}
