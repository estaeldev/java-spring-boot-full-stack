package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping
    public List<User> findAll() {
        return this.userDaoService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return this.userDaoService.findById(id);
    }
    
    @PostMapping
    public User save(@RequestBody User user) {
        return this.userDaoService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.userDaoService.delete(id);
    }
    
    
}
