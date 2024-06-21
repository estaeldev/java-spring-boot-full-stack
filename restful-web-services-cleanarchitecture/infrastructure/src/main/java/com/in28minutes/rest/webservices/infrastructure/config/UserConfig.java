package com.in28minutes.rest.webservices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.rest.webservices.application.gateway.CreateUserGateway;
import com.in28minutes.rest.webservices.application.gateway.FindUserGateway;
import com.in28minutes.rest.webservices.application.usecaseimpl.CreateUserImpl;
import com.in28minutes.rest.webservices.application.usecaseimpl.FindUserImpl;
import com.in28minutes.rest.webservices.usecase.CreateUser;
import com.in28minutes.rest.webservices.usecase.FindUser;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(CreateUserGateway createUserGateway) {
        return new CreateUserImpl(createUserGateway);
    }

    @Bean
    FindUser findUser(FindUserGateway findUserGateway) {   
        return new FindUserImpl(findUserGateway);
    }
    
}
