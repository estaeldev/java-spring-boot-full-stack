package com.in28minutes.rest.webservices.core.domain;

import java.util.UUID;

public class Post {
    
    private UUID id;
    private String description;
    private UUID userId;

    public Post() {}

    public Post(UUID id, String description, UUID userId) {
        this.id = id;
        this.description = description;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    
    

}
