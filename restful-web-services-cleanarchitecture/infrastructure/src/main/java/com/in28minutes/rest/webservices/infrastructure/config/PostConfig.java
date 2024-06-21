package com.in28minutes.rest.webservices.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.rest.webservices.application.gateway.CreatePostGateway;
import com.in28minutes.rest.webservices.application.gateway.FindPostGateway;
import com.in28minutes.rest.webservices.application.usecaseimpl.CreatePostImpl;
import com.in28minutes.rest.webservices.application.usecaseimpl.FindPostImpl;
import com.in28minutes.rest.webservices.usecase.CreatePost;
import com.in28minutes.rest.webservices.usecase.FindPost;

@Configuration
public class PostConfig {

    @Bean
    CreatePost createPost(CreatePostGateway createPostGateway) {
        return new CreatePostImpl(createPostGateway);
    }

    @Bean
    FindPost findPost(FindPostGateway findPostGateway) {
        return new FindPostImpl(findPostGateway);
    }
    
}
