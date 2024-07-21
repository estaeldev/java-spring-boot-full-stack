package com.project.learn_oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloWorldController {
    
    @GetMapping
    public Object helloWorld(Authentication authentication) {
        return authentication.getPrincipal();
    }

}
