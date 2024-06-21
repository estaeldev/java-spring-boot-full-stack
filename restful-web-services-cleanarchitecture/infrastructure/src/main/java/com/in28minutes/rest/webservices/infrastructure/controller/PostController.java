package com.in28minutes.rest.webservices.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.infrastructure.dto.PostDto;
import com.in28minutes.rest.webservices.infrastructure.mapper.PostMapper;
import com.in28minutes.rest.webservices.usecase.CreatePost;
import com.in28minutes.rest.webservices.usecase.FindPost;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final CreatePost createPost;
    private final FindPost findPost;
    private final PostMapper postMapper;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody final PostDto postDto) {
        Post post = this.postMapper.fromDtoToModel(postDto);
        Post postCreated = this.createPost.create(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(postCreated);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Post> postList = this.findPost.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }
    

    
}
