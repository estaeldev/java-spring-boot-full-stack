package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.FindUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.NotFoundException;
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
            throw new NotFoundException(ErrorCodeEnum.US0002.getMessage(), ErrorCodeEnum.US0002.getCode());
        }
        
        return userFind;

    }

    @Override
    public List<User> findAll() {
        return this.findUserGateway.findAll();
    }
    
}
