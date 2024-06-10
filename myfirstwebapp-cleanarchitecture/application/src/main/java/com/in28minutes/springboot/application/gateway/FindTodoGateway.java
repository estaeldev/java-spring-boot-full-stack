package com.in28minutes.springboot.application.gateway;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.Todo;

public interface FindTodoGateway {

    Todo find(Todo todo);
    Todo findById(UUID id);
    
}
