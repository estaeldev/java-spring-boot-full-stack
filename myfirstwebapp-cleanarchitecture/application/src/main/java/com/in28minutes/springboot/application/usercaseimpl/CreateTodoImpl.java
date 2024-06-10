package com.in28minutes.springboot.application.usercaseimpl;

import com.in28minutes.springboot.application.gateway.CreateTodoGateway;
import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.core.exception.BadRequestException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.CreateTodo;

public class CreateTodoImpl implements CreateTodo {

    private final CreateTodoGateway createTodoGateway;

    public CreateTodoImpl(CreateTodoGateway createTodoGateway) {
        this.createTodoGateway = createTodoGateway;
    }

    @Override
    public void create(Todo todo) {
       
        Boolean isCreated = this.createTodoGateway.create(todo);

        if(Boolean.FALSE.equals(isCreated)) {
            throw new BadRequestException(ErrorCodeEnum.TO0001.getMessage(), ErrorCodeEnum.TO0001.getCode());
        }

    }
    
}
