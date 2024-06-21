package com.in28minutes.rest.webservices.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.core.domain.User;
import com.in28minutes.rest.webservices.infrastructure.dto.UserDto;
import com.in28minutes.rest.webservices.infrastructure.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PostMapper postMapper;

    public UserEntity fromModelToEntity(User user) {

        return new UserEntity(
            user.getId(), 
            user.getName(), 
            user.getBirthDate(), 
            user.getUserType(),
            user.getPosts().stream().map(this.postMapper::fromModelToEntity).toList()
        );
    }

    public User fromEntityToModel(UserEntity userEntity) {

        return new User(
            userEntity.getId(), 
            userEntity.getName(), 
            userEntity.getBirthDate(), 
            userEntity.getUserType(),
            userEntity.getPosts().stream().map(this.postMapper::fromEntityToModel).toList()
        );
    }

    public User fromDtoToModel(UserDto userDto) {

        return new User(
            userDto.getId(), 
            userDto.getName(), 
            userDto.getBirthDate(), 
            userDto.getUserType(),
            userDto.getPosts()
        );
    }

}
