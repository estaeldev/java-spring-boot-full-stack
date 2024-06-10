package com.in28minutes.springboot.application.gateway;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.Todo;

public interface DeleteTodoGateway {
    
    Boolean delete(Todo todo);
    Boolean deleteById(UUID id);

}
