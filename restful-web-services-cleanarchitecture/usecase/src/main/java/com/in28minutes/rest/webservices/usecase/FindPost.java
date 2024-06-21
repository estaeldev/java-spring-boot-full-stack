package com.in28minutes.rest.webservices.usecase;

import java.util.List;
import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface FindPost {

    Post findById(UUID id);

    List<Post> findAll();
    
}
