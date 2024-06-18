package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.Objects;

import com.in28minutes.rest.webservices.application.gateway.CreatePostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.CreatePost;

public class CreatePostImpl implements CreatePost {

    private final CreatePostGateway createPostGateway;
    
    public CreatePostImpl(CreatePostGateway createPostGateway) {
        this.createPostGateway = createPostGateway;
    }

    @Override
    public Post create(Post post) {

        Post postSaved = this.createPostGateway.create(post);

        if(Objects.isNull(postSaved)) {
            throw new BusinessException(ErrorCodeEnum.BU0001.getMessage(), ErrorCodeEnum.BU0001.getCode());
        }

        return postSaved;

    }
    
}
