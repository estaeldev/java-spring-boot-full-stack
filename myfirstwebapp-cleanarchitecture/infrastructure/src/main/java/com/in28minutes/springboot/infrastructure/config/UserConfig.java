package com.in28minutes.springboot.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.springboot.application.gateway.CreateUserGateway;
import com.in28minutes.springboot.application.usercaseimpl.CreateUserImpl;
import com.in28minutes.springboot.usecase.CreateUser;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(CreateUserGateway createUserGateway) {
        return new CreateUserImpl(createUserGateway);
    }
    
}
