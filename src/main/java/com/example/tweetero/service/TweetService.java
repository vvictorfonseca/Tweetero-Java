package com.example.tweetero.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tweetero.dto.tweetDto;
import com.example.tweetero.model.Tweet;
import com.example.tweetero.model.User;
import com.example.tweetero.repository.TweetRepository;
import com.example.tweetero.repository.UserRepsitory;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository repository;

  @Autowired
  private UserRepsitory userRepsitory;

  public ResponseEntity<Tweet> newTweet(tweetDto tweet) {
    Optional<User> userExist = userRepsitory.findByUsername(tweet.username());

    if(userExist.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    repository.save(new Tweet(tweet));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
