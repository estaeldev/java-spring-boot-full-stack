package com.in28minutes.springboot.application.gateway;

import com.in28minutes.springboot.core.domain.Todo;

public interface CreateTodoGateway {
    
    Boolean create(Todo todo);

}
