package com.in28minutes.rest.webservices.application.gateway;

import java.util.List;
import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface FindPostGateway {

    Post findById(UUID id);

    List<Post> findAll();
    
}
