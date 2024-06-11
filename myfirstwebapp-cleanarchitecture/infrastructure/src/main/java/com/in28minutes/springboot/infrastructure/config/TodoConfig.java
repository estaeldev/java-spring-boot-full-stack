package com.in28minutes.springboot.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.springboot.application.gateway.CreateTodoGateway;
import com.in28minutes.springboot.application.gateway.FindUserGateway;
import com.in28minutes.springboot.application.usercaseimpl.CreateTodoImpl;
import com.in28minutes.springboot.application.usercaseimpl.FindUserImpl;
import com.in28minutes.springboot.usecase.CreateTodo;
import com.in28minutes.springboot.usecase.FindUser;

@Configuration
public class TodoConfig {

    @Bean
    CreateTodo createTodo(CreateTodoGateway createTodoGateway) {
        return new CreateTodoImpl(createTodoGateway);
    }

    @Bean
    FindUser findUser(FindUserGateway findUserGateway) {
        return new FindUserImpl(findUserGateway);
    }
    
}
