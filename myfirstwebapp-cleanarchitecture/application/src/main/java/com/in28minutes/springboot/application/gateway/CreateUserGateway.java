package com.in28minutes.springboot.application.gateway;

import com.in28minutes.springboot.core.domain.User;

public interface CreateUserGateway {
    
    Boolean create(User user);

}
