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
    private List<UUID> postsId;

    public User() {}

    public User(UUID id, String name, LocalDate birthDate, UserType userType, List<UUID> postsId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.userType = userType;
        this.postsId = postsId;
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

    public List<UUID> getPostsId() {
        return postsId;
    }

    public void setPostsId(List<UUID> postsId) {
        this.postsId = postsId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
}
