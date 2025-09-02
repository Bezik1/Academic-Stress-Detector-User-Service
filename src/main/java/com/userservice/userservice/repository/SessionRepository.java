package com.userservice.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.userservice.model.Session;


public interface SessionRepository extends JpaRepository<Session, Long>{
    List<Session> findByUserId(Long userId);
}
