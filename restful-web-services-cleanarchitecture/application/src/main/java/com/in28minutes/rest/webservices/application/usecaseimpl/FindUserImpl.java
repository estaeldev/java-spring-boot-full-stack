package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.FindUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.FindUser;

public class FindUserImpl implements FindUser {

    private final FindUserGateway findUserGateway;

    public FindUserImpl(FindUserGateway findUserGateway) {
        this.findUserGateway = findUserGateway;
    }

    @Override
    public User findById(UUID id) {

        User userFind = this.findUserGateway.findById(id);

        if(Objects.isNull(userFind)) {
            throw new BusinessException(ErrorCodeEnum.PO0002.getMessage(), ErrorCodeEnum.PO0002.getCode());
        }
        
        return userFind;

    }
    
}
