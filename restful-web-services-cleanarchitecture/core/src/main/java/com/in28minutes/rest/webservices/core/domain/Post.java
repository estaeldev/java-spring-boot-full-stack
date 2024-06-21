package com.in28minutes.rest.webservices.core.domain;

import java.util.UUID;

public class Post {
    
    private UUID id;
    private String description;

    public Post() {}

    public Post(UUID id, String description) {
        this.id = id;
        this.description = description;
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

}
