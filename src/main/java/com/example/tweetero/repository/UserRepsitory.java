package com.example.tweetero.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tweetero.model.User;

public interface UserRepsitory extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
}
