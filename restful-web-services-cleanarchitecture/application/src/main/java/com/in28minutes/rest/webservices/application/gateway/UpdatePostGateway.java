package com.in28minutes.rest.webservices.application.gateway;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface UpdatePostGateway {

    Post update(Post post);

    Post updateById(UUID id, Post post);
    
}
