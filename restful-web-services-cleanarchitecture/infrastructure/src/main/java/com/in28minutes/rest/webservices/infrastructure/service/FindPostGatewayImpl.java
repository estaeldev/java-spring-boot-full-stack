package com.in28minutes.rest.webservices.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.in28minutes.rest.webservices.application.gateway.FindPostGateway;
import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.infrastructure.entity.PostEntity;
import com.in28minutes.rest.webservices.infrastructure.mapper.PostMapper;
import com.in28minutes.rest.webservices.infrastructure.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPostGatewayImpl implements FindPostGateway {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public Post findById(UUID id) {
        Optional<PostEntity> postEntityOpt = this.postRepository.findById(id);
        return postEntityOpt.map(this.postMapper::fromEntityToModel).orElse(null);
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> postEntityList = this.postRepository.findAll();
        return postEntityList.stream().map(this.postMapper::fromEntityToModel).toList();
    }

    
}
