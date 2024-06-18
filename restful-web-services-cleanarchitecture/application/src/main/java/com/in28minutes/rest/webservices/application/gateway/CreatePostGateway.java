package com.in28minutes.rest.webservices.application.gateway;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface CreatePostGateway {

    Post create(Post post);
    
}
