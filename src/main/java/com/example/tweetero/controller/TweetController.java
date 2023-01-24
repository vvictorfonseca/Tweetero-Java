package com.example.tweetero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tweetero.dto.tweetDto;
import com.example.tweetero.model.Tweet;
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

  @GetMapping
  public ResponseEntity<Page<Tweet>> getAllTweets(@RequestParam(defaultValue = "0") int page) {
    Page<Tweet> tweets = service.listTweets(page);

    return ResponseEntity.ok().body(tweets);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<Tweet>> getAllTweetsByUsername(@PathVariable String username) {
    List<Tweet> tweets = service.listTweetsByUsername(username);

    return ResponseEntity.ok().body(tweets);
  }
  
}
