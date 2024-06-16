package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import java.util.List;

public interface UserDaoService {

    public List<User> findAll();

    public User findById(Integer id);
    
    public User save(User user);

    public void deleteById(Integer id);
    
}
