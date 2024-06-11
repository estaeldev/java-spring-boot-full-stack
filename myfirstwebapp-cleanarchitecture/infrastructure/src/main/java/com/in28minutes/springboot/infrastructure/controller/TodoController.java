package com.in28minutes.springboot.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.core.domain.Todo;
import com.in28minutes.springboot.infrastructure.dto.BaseResponseDto;
import com.in28minutes.springboot.infrastructure.dto.TodoRequestDto;
import com.in28minutes.springboot.infrastructure.mapper.TodoMapper;
import com.in28minutes.springboot.usecase.CreateTodo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final CreateTodo createTodo;
    private final TodoMapper todoMapper;

    @PostMapping
    public ResponseEntity<BaseResponseDto<?>> create(@Valid @RequestBody TodoRequestDto todoDto) {
        
        Todo todo = this.todoMapper.todo(todoDto);
        this.createTodo.create(todo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponseDto.builder()
            .message("Todo criado com sucesso")
            .code(HttpStatus.CREATED.toString())
            .build()
        );
    }

    
}
