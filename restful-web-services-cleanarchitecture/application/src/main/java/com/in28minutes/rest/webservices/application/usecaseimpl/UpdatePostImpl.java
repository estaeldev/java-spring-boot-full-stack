package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.UpdatePostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.UpdatePost;

public class UpdatePostImpl implements UpdatePost {

    private final UpdatePostGateway updatePostGateway;
    
    public UpdatePostImpl(UpdatePostGateway updatePostGateway) {
        this.updatePostGateway = updatePostGateway;
    }

    @Override
    public Post update(Post post) {

        Post postUpdate = this.updatePostGateway.update(post);

        if(Objects.isNull(postUpdate)) {
            throw new BusinessException(ErrorCodeEnum.BU0003.getMessage(), ErrorCodeEnum.BU0003.getCode());
        }

        return postUpdate;

    }

    @Override
    public Post updateById(UUID id, Post post) {

        Post postUpdate = this.updatePostGateway.updateById(id, post);

        if(Objects.isNull(postUpdate)) {
            throw new BusinessException(ErrorCodeEnum.BU0003.getMessage(), ErrorCodeEnum.BU0003.getCode());
        }

        return postUpdate;

    }
    
}
