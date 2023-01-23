package com.example.tweetero.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tweetero.model.User;

public interface UserRepsitory extends JpaRepository<User, Long> {
  @Query("SELECT * FROM users WHERE users.username = ?1")
  Optional<User> findByUsername(String username);
}
