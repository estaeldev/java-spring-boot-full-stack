package com.in28minutes.springboot.application.usercaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.springboot.application.gateway.FindUserGateway;
import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.core.exception.NotFoundException;
import com.in28minutes.springboot.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.springboot.usecase.FindUser;

public class FindUserImpl implements FindUser  {

    private final FindUserGateway findUserGateway;

    public FindUserImpl(FindUserGateway findUserGateway) {
        this.findUserGateway = findUserGateway;
    }


    @Override
    public void findById(UUID id) {

        User findUser = this.findUserGateway.findById(id);

        if(Objects.isNull(findUser)) {
            throw new NotFoundException(ErrorCodeEnum.US0003.getMessage(), ErrorCodeEnum.US0003.getCode());
        }

    }
    
}
