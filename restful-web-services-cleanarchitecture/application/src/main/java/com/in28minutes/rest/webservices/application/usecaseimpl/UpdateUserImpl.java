package com.in28minutes.rest.webservices.application.usecaseimpl;

import java.util.Objects;
import java.util.UUID;

import com.in28minutes.rest.webservices.application.gateway.UpdateUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.BusinessException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.usecase.UpdateUser;

public class UpdateUserImpl implements UpdateUser {

    private final UpdateUserGateway updateUserGateway;

    public UpdateUserImpl(UpdateUserGateway updateUserGateway) {
        this.updateUserGateway = updateUserGateway;
    }

    @Override
    public User update(User user) {

        User userUpdate = this.updateUserGateway.update(user);

        if(Objects.isNull(userUpdate)) {
            throw new BusinessException(ErrorCodeEnum.BU0004.getMessage(), ErrorCodeEnum.BU0004.getCode());
        }

        return userUpdate;

    }

    @Override
    public User updateById(UUID id, User user) {

        User userUpdate = this.updateUserGateway.updateById(id, user);

        if(Objects.isNull(userUpdate)) {
            throw new BusinessException(ErrorCodeEnum.BU0004.getMessage(), ErrorCodeEnum.BU0004.getCode());
        }

        return userUpdate;

    }
    
}
