package com.in28minutes.rest.webservices.restful_web_services.socialmediaapplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    

}
