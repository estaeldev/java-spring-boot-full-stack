package com.in28minutes.rest.webservices.infrastructure.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.application.gateway.CreatePostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.exception.BadRequestException;
import com.in28minutes.rest.webservices.core.exception.enums.ErrorCodeEnum;
import com.in28minutes.rest.webservices.infrastructure.entity.PostEntity;
import com.in28minutes.rest.webservices.infrastructure.mapper.PostMapper;
import com.in28minutes.rest.webservices.infrastructure.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreatePostGatewayImpl implements CreatePostGateway {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public Post create(Post post) {

        PostEntity postEntity = this.postMapper.fromModelToEntity(post);

        if(Objects.nonNull(postEntity.getId())) {
            throw new BadRequestException(ErrorCodeEnum.PO0003.getMessage(), ErrorCodeEnum.PO0003.getCode());
        }

        PostEntity postEntitySaved = this.postRepository.save(postEntity);
        return this.postMapper.fromEntityToModel(postEntitySaved);
    }
    
}
