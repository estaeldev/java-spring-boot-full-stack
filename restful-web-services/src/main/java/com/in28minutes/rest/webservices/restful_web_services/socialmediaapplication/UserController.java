package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService userDaoService;
    private final PostRepository postRepository;

    public UserController(UserDaoService userDaoService, PostRepository postRepository) {
        this.userDaoService = userDaoService;
        this.postRepository = postRepository;
    }

    @GetMapping
    public  ResponseEntity<List<User>> findAll() {
        List<User> userList = this.userDaoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<User>> findById(@PathVariable Integer id) {
        User user = this.userDaoService.findById(id);

        if(Objects.isNull(user)) {
            throw new UserNotFoundException("User Not Found; id:"+id);
        }

        EntityModel<User> entityModelUser = EntityModel.of(user);
        WebMvcLinkBuilder findAllLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        WebMvcLinkBuilder deleteLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).delete(id));

        entityModelUser.add(findAllLink.withRel("all-users"));
        entityModelUser.add(deleteLink.withRel("delete-user"));
        
        return ResponseEntity.status(HttpStatus.OK).body(entityModelUser);
    }
    
    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        User userSaved = this.userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userSaved.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.userDaoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findAllPostsForUser(@PathVariable Integer id) {

        User user = this.userDaoService.findById(id);

        if(Objects.nonNull(user)) {
            return ResponseEntity.status(HttpStatus.OK).body(user.getPosts());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> savePost(@PathVariable int id, @Valid @RequestBody Post post) {
        
        User user = this.userDaoService.findById(id);

        if(Objects.nonNull(user)) {
            post.setUser(user);
            this.postRepository.save(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(post);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/{userId}/posts/{postId}")
    public ResponseEntity<Post> findByIdPost(@PathVariable int userId, @PathVariable int postId) {
        
        User user = this.userDaoService.findById(userId);

        if(Objects.nonNull(user)) {
            Optional<Post> postOpt = this.postRepository.findById(postId);

            if(postOpt.isPresent() && user.getPosts().stream().anyMatch(post -> post.getId().equals(postOpt.get().getId()))) {
                return ResponseEntity.status(HttpStatus.OK).body(postOpt.get());
            }

        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    
    
}
