package com.in28minutes.springboot.infrastructure.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.application.gateway.CreateTodoGateway;
import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.infrastructure.entity.TodoEntity;
import com.in28minutes.springboot.infrastructure.entity.UserEntity;
import com.in28minutes.springboot.infrastructure.mapper.TodoMapper;
import com.in28minutes.springboot.infrastructure.mapper.UserMapper;
import com.in28minutes.springboot.infrastructure.repository.TodoRepository;
import com.in28minutes.springboot.usecase.FindUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateTodoGatewayImpl implements CreateTodoGateway {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final UserMapper userMapper;
    private final FindUser findUser;

    @Override
    public Boolean create(Todo todo) {

        User user = this.findUser.findById(todo.getUser().getId());
        UserEntity userEntity = this.userMapper.userEntity(user);

        TodoEntity todoEntity = this.todoMapper.todoEntity(todo, userEntity);
        TodoEntity todoEntitySaved = this.todoRepository.save(todoEntity);

        return !Objects.isNull(todoEntitySaved);

    }
    
}
