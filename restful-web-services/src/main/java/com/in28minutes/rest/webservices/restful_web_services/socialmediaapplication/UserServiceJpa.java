package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceJpa implements UserDaoService {

    private final UserRepository userRepository;

    public UserServiceJpa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> userOpt = this.userRepository.findById(id);
        return userOpt.orElse(null);
    }

    @Override
    public User save(User user) {

        if(Objects.isNull(user.getId())) {
            return this.userRepository.save(user);
        }

        return null;
    }

    @Override
    public void deleteById(Integer id) {

        if(Objects.nonNull(findById(id))) {
            this.userRepository.deleteById(id);
        } 

    }
    
}
