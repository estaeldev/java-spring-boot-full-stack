package com.in28minutes.rest.webservices.usecase;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface DeletePost {
    
    void delete(Post post);

    void deleteById(UUID id);

}
