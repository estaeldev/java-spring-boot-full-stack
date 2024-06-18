package com.in28minutes.rest.webservices.usecase;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.User;

public interface DeleteUser {

    void delete(User user);

    void deleteById(UUID id);
    
}
