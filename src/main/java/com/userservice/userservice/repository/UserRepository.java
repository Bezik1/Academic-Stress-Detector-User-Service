package com.userservice.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByName(String username);
}
