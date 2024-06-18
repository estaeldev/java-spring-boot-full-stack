package com.in28minutes.rest.webservices.application.gateway;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.User;

public interface FindUserGateway {

    User findById(UUID id);
    
}
