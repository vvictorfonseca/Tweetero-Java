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
  private UserRepsitory userRepsitory;

  public ResponseEntity<User> userSignUp(userDto signUp) {
    Optional<User> userExist = userRepsitory.findByUsername(signUp.username());

    if (!userExist.isPresent()) {
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    userRepsitory.save(new User(signUp));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  
}
