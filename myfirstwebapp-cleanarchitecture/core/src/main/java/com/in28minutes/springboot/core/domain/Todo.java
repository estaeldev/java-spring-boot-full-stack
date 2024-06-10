package com.in28minutes.springboot.core.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Todo {
    
    private UUID id;
    private User user;
    private String description;
    private LocalDate targetDate;
    private Boolean done;

    public Todo() {}

    public Todo(UUID id, User user, String description, LocalDate targetDate, Boolean done) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((targetDate == null) ? 0 : targetDate.hashCode());
        result = prime * result + ((done == null) ? 0 : done.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (targetDate == null) {
            if (other.targetDate != null)
                return false;
        } else if (!targetDate.equals(other.targetDate))
            return false;
        if (done == null) {
            if (other.done != null)
                return false;
        } else if (!done.equals(other.done))
            return false;
        return true;
    }
    

}
