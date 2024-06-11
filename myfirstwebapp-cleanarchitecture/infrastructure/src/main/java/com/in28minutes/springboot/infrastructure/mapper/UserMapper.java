package com.in28minutes.springboot.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.in28minutes.springboot.core.domain.User;
import com.in28minutes.springboot.infrastructure.entity.UserEntity;

@Component
public class UserMapper {

    public UserEntity userEntity(User user) {

        return new UserEntity(
            user.getId(), 
            user.getUserTypeEnum(), 
            user.getLogin(), 
            user.getPassword());
    }

    public User user(UserEntity userEntity) {
        
        return new User(
            userEntity.getId(), 
            userEntity.getUserTypeEnum(), 
            userEntity.getLogin(), 
            userEntity.getPassword());
    }
    
}
