package com.in28minutes.rest.webservices.core.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.enums.UserType;

public class User {

    private UUID id;
    private String name;
    private LocalDate birthDate;
    private UserType userType;
    private List<Post> posts;

    public User() {}

    public User(UUID id, String name, LocalDate birthDate, UserType userType, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.userType = userType;
        this.posts = posts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
}
