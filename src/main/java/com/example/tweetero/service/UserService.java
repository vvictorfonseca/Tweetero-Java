package com.example.tweetero.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tweetero.dto.userDto;
import com.example.tweetero.model.User;
import com.example.tweetero.repository.UserRepsitory;

@Service
public class UserService {

  @Autowired
  private UserRepsitory repository;

  public ResponseEntity<String> userSignUp(userDto signUp) {
    Optional<User> usernameExist = repository.findByUsername(signUp.username());
    
    if(usernameExist.isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    repository.save(new User(signUp));
    return new ResponseEntity<>("OK", HttpStatus.CREATED);
  }
  
}
