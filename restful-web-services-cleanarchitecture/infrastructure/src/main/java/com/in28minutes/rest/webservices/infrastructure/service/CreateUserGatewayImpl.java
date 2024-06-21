package com.in28minutes.rest.webservices.infrastructure.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.application.gateway.CreateUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.core.exception.BadRequestException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.infrastructure.entity.UserEntity;
import com.in28minutes.rest.webservices.infrastructure.mapper.UserMapper;
import com.in28minutes.rest.webservices.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User create(User user) {

        UserEntity userEntity = this.userMapper.fromModelToEntity(user);

        if(Objects.nonNull(userEntity.getId())) {
            throw new BadRequestException(ErrorCodeEnum.US0003.getMessage(), ErrorCodeEnum.US0003.getCode());
        }

        UserEntity userEntitySaved = this.userRepository.save(userEntity);
        return this.userMapper.fromEntityToModel(userEntitySaved);

    }
    
}
