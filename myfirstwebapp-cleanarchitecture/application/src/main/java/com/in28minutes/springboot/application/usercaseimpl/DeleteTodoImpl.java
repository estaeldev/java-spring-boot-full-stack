package com.in28minutes.springboot.application.usercaseimpl;

import java.util.UUID;

import com.in28minutes.springboot.application.gateway.DeleteTodoGateway;
import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.core.exception.NotFoundException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.DeleteTodo;

public class DeleteTodoImpl implements DeleteTodo {

    private final DeleteTodoGateway deleteTodoGateway;

    public DeleteTodoImpl(DeleteTodoGateway deleteTodoGateway) {
        this.deleteTodoGateway = deleteTodoGateway;
    }

    @Override
    public void delete(Todo todo) {
        Boolean isDelete = this.deleteTodoGateway.delete(todo);

        if(Boolean.FALSE.equals(isDelete)) {
            throw new NotFoundException(ErrorCodeEnum.TO0002.getMessage(), ErrorCodeEnum.TO0002.getCode());
        }

    }

    @Override
    public void deleteById(UUID id) {
        Boolean isDelete = this.deleteTodoGateway.deleteById(id);

        if(Boolean.FALSE.equals(isDelete)) {
            throw new NotFoundException(ErrorCodeEnum.TO0003.getMessage(), ErrorCodeEnum.TO0003.getCode());
        }

    }
    
}
