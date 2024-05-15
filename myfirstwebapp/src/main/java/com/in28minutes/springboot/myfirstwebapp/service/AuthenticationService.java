package com.in28minutes.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    public Boolean authenticate(String username, String password) {
        
        if(username.equals("estael") && password.equals("1234")) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
}
