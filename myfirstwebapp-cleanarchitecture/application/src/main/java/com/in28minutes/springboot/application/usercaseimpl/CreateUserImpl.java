package com.in28minutes.springboot.application.usercaseimpl;

import com.in28minutes.springboot.application.gateway.CreateUserGateway;
import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.core.exception.BadRequestException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.CreateUser;

public class CreateUserImpl implements CreateUser {

    private final CreateUserGateway createUserGateway;

    public CreateUserImpl(CreateUserGateway createUserGateway) {
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user) {

        Boolean isCreated = this.createUserGateway.create(user);

        if(Boolean.FALSE.equals(isCreated)) {
            throw new BadRequestException(ErrorCodeEnum.US0001.getMessage(), ErrorCodeEnum.US0001.getCode());
        }

    }
    
}
