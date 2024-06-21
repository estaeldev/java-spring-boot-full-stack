package com.in28minutes.rest.webservices.usecase;

import java.util.List;
import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.User;

public interface FindUser {
    
    User findById(UUID id);

    List<User> findAll();

}
