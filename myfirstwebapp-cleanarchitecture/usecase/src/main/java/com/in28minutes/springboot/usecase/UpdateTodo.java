package com.in28minutes.springboot.usecase;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.Todo;

public interface UpdateTodo {
    
    void update(UUID id, Todo todo);

}
