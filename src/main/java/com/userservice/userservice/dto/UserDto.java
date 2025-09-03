package com.userservice.userservice.dto;

import com.userservice.userservice.model.User;

public class UserDto {
    private Long id;
    private String email;
    private String username;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}