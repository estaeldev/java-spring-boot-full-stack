package com.in28minutes.springboot.usecase;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.User;

public interface FindUser {
    
    User findById(UUID id);

}
