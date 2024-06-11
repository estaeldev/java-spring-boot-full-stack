package com.in28minutes.springboot.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.infrastructure.entity.TodoEntity;
import com.in28minutes.springboot.infrastructure.entity.UserEntity;

@Component
public class TodoMapper {

    public TodoEntity todoEntity(Todo todo, UserEntity userEntity) {

        return new TodoEntity(
            todo.getId(), 
            userEntity, 
            todo.getDescription(), 
            todo.getTargetDate(), 
            todo.getDone());
    }
    
}
