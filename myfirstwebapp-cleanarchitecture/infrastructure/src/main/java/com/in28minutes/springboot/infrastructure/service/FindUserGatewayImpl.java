package com.in28minutes.springboot.infrastructure.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.application.gateway.FindUserGateway;
import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.infrastructure.entity.UserEntity;
import com.in28minutes.springboot.infrastructure.mapper.UserMapper;
import com.in28minutes.springboot.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindUserGatewayImpl implements FindUserGateway  {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findById(UUID id) {

        Optional<UserEntity> userEntityOpt = this.userRepository.findById(id);

        if(userEntityOpt.isEmpty()) {
            return null;
        }

        return this.userMapper.user(userEntityOpt.get());

    }
    
}
