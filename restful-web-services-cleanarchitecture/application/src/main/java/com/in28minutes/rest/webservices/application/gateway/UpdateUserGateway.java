package com.in28minutes.rest.webservices.application.gateway;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.User;

public interface UpdateUserGateway {

    User update(User user);

    User updateById(UUID id, User user);
    
}
