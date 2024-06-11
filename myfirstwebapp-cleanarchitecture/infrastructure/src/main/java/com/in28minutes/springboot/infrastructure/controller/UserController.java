package com.in28minutes.springboot.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.infrastructure.dto.UserRequestDto;
import com.in28minutes.springboot.infrastructure.mapper.UserMapper;
import com.in28minutes.springboot.usecase.CreateUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;
    private final UserMapper userMapper;
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequestDto userRequestDto) {
        User user = this.userMapper.user(userRequestDto);
        this.createUser.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso.");
    }


}
