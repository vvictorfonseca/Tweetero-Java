package com.example.tweetero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweetero.dto.userDto;
import com.example.tweetero.service.UserService;

@RestController
@RequestMapping("/sign-up")
public class UserController {

  @Autowired
  private UserService userService;
  
  @PostMapping
  public ResponseEntity<?> userSignUp(@RequestBody userDto req) {
    return userService.userSignUp(req);
  }
}
