package com.in28minutes.springboot.infrastructure.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.application.gateway.CreateUserGateway;
import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.infrastructure.entity.UserEntity;
import com.in28minutes.springboot.infrastructure.mapper.UserMapper;
import com.in28minutes.springboot.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateUserGatewayImpl implements CreateUserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Boolean create(User user) {

        UserEntity userEntity = this.userMapper.userEntity(user);
        UserEntity userEntitySaved = this.userRepository.save(userEntity);

        return !Objects.isNull(userEntitySaved);

    }
    
}
