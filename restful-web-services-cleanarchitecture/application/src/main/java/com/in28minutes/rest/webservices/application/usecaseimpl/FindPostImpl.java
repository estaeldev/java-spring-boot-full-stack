package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.FindPostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.exception.NotFoundException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.FindPost;

public class FindPostImpl implements FindPost {

    private final FindPostGateway findPostGateway;

    public FindPostImpl(FindPostGateway findPostGateway) {
        this.findPostGateway = findPostGateway;
    }

    @Override
    public Post findById(UUID id) {

        Post postFind = this.findPostGateway.findById(id);

        if(Objects.isNull(postFind)) {
            throw new NotFoundException(ErrorCodeEnum.PO0002.getMessage(), ErrorCodeEnum.PO0002.getCode());
        }

        return postFind;
    }

    @Override
    public List<Post> findAll() {
        return this.findPostGateway.findAll();
    }
    
}
