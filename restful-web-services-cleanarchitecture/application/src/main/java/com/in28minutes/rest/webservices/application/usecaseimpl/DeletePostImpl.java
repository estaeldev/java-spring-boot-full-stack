package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.DeletePostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.DeletePost;

public class DeletePostImpl implements DeletePost {

    private final DeletePostGateway deletePostGateway;

    public DeletePostImpl(DeletePostGateway deletePostGateway) {
        this.deletePostGateway = deletePostGateway;
    }

    @Override
    public void delete(Post post) {

        Boolean isDeleted = this.deletePostGateway.delete(post);

        if(Boolean.FALSE.equals(isDeleted)) {
            throw new BusinessException(ErrorCodeEnum.PO0001.getMessage(), ErrorCodeEnum.PO0001.getCode());
        }

    }

    @Override
    public void deleteById(UUID id) {

        Boolean isDeleted = this.deletePostGateway.deleteById(id);

        if(Boolean.FALSE.equals(isDeleted)) {
            throw new BusinessException(ErrorCodeEnum.PO0001.getMessage(), ErrorCodeEnum.PO0001.getCode());
        }

    }
    
}
