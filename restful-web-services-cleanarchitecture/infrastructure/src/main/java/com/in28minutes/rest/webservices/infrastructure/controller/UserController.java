package com.in28minutes.rest.webservices.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.infrastructure.dto.UserDto;
import com.in28minutes.rest.webservices.infrastructure.mapper.UserMapper;
import com.in28minutes.rest.webservices.usecase.CreateUser;
import com.in28minutes.rest.webservices.usecase.FindUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final UserDto userDto) {
        User user = this.userMapper.fromDtoToModel(userDto);
        User userCreated = this.createUser.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
    
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<User> userList = this.findUser.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
    
}
