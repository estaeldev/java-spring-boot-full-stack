package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.DeleteUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.DeleteUser;

public class DeleteUserImpl implements DeleteUser {

    private final DeleteUserGateway deleteUserGateway;

    public DeleteUserImpl(DeleteUserGateway deleteUserGateway) {
        this.deleteUserGateway = deleteUserGateway;
    }

    @Override
    public void delete(User user) {

        Boolean isDeleted = this.deleteUserGateway.delete(user);

        if(Boolean.FALSE.equals(isDeleted)) {
            throw new BusinessException(ErrorCodeEnum.US0001.getMessage(), ErrorCodeEnum.US0001.getCode());
        }

    }

    @Override
    public void deleteById(UUID id) {

        Boolean isDeleted = this.deleteUserGateway.deleteById(id);

        if(Boolean.FALSE.equals(isDeleted)) {
            throw new BusinessException(ErrorCodeEnum.US0001.getMessage(), ErrorCodeEnum.US0001.getCode());
        }

    }
    
}
