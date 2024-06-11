package com.in28minutes.springboot.application.gateway;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.User;

public interface FindUserGateway {
    
    User findById(UUID id);

}
