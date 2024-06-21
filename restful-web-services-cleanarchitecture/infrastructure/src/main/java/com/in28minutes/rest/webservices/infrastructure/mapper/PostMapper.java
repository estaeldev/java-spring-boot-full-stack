package com.in28minutes.rest.webservices.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.infrastructure.dto.PostDto;
import com.in28minutes.rest.webservices.infrastructure.entity.PostEntity;

@Component
public class PostMapper {

    public PostEntity fromModelToEntity(Post post) {
        return new PostEntity(post.getId(), post.getDescription());
    }

    public Post fromEntityToModel(PostEntity postEntity) {
        return new Post(postEntity.getId(), postEntity.getDescription());
    }

    public Post fromDtoToModel(PostDto postDto) {
        return new Post(postDto.getId(), postDto.getDescription());
    }
    
}
