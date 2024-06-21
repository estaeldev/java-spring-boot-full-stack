package com.in28minutes.rest.webservices.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.application.gateway.FindUserGateway;
import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.infrastructure.entity.UserEntity;
import com.in28minutes.rest.webservices.infrastructure.mapper.UserMapper;
import com.in28minutes.rest.webservices.infrastructure.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindUserGatewayImpl implements FindUserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User findById(UUID id) {
        Optional<UserEntity> userEntityOpt = this.userRepository.findById(id);
        return userEntityOpt.map(this.userMapper::fromEntityToModel).orElse(null);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntityList = this.userRepository.findAll();
        return userEntityList.stream().map(this.userMapper::fromEntityToModel).toList();
    }
    
}
