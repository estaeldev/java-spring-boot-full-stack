package com.in28minutes.rest.webservices.usecase;

import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;

public interface UpdatePost {

    Post update(Post post);

    Post updateById(UUID id, Post post);

}
