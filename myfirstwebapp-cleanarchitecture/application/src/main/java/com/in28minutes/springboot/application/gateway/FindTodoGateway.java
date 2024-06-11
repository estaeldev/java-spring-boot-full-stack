package com.in28minutes.springboot.application.gateway;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.Todo;

public interface FindTodoGateway {

    Todo findById(UUID id);
    
}
