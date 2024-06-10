package com.in28minutes.springboot.application.usercaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.springboot.application.gateway.FindTodoGateway;
import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.core.exception.NotFoundException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.FindTodo;

public class FindTodoImpl implements FindTodo {

    private final FindTodoGateway findTodoGateway;
    
    public FindTodoImpl(FindTodoGateway findTodoGateway) {
        this.findTodoGateway = findTodoGateway;
    }

    @Override
    public void find(Todo todo) {
        Todo findTodo = this.findTodoGateway.find(todo);

        if(Objects.isNull(findTodo)) {
            throw new NotFoundException(ErrorCodeEnum.TO0004.getMessage(), ErrorCodeEnum.TO0004.getCode());
        }

    }

    @Override
    public void findById(UUID id) {

        Todo findTodo = this.findTodoGateway.findById(id);

        if(Objects.isNull(findTodo)) {
            throw new NotFoundException(ErrorCodeEnum.TO0005.getMessage(), ErrorCodeEnum.TO0005.getCode());
        }
       
    }
    

}
