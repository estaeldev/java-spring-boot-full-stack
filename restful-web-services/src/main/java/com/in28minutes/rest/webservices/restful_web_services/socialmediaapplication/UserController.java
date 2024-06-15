package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
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
    
    
}
