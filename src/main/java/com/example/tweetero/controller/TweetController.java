package com.example.tweetero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweetero.dto.tweetDto;
import com.example.tweetero.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public ResponseEntity<?> newTweet(@RequestBody tweetDto req) {
    return service.newTweet(req);
  }
  
}
