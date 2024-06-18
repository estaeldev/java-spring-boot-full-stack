package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.Objects;

import com.in28minutes.rest.webservices.application.gateway.CreateUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.CreateUser;

public class CreateUserImpl implements CreateUser {

    private final CreateUserGateway createUserGateway;

    public CreateUserImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public User create(User user) {

        User userSaved = this.createUserGateway.create(user);

        if(Objects.isNull(userSaved)) {
            throw new BusinessException(ErrorCodeEnum.BU0002.getMessage(), ErrorCodeEnum.BU0002.getCode());
        }
        
        return userSaved;

    }
    
}
