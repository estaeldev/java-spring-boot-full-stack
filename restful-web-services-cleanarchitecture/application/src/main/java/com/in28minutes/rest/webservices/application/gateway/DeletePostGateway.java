package com.in28minutes.rest.webservices.application.gateway;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface DeletePostGateway {
    
    Boolean delete(Post post);

    Boolean deleteById(UUID id);

}
