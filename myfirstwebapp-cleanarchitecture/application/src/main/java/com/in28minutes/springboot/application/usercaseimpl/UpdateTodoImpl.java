package com.in28minutes.springboot.application.usercaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.springboot.application.gateway.UpdateTodoGateway;
import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.core.exception.BadRequestException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.UpdateTodo;

public class UpdateTodoImpl implements UpdateTodo {

    private final UpdateTodoGateway updateTodoGateway;

    public UpdateTodoImpl(UpdateTodoGateway updateTodoGateway) {
        this.updateTodoGateway = updateTodoGateway;
    }

    @Override
    public void update(UUID id, Todo todo) {

        Todo updateTodo = this.updateTodoGateway.update(id, todo);

        if(Objects.isNull(updateTodo)) {
            throw new BadRequestException(ErrorCodeEnum.TO0006.getMessage(), ErrorCodeEnum.TO0006.getCode());
        }

    }
    
}
