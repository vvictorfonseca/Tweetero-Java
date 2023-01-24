package com.example.tweetero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

  public ResponseEntity<String> newTweet(tweetDto tweet) {
    Optional<User> userExist = userRepsitory.findByUsername(tweet.username());

    if(userExist.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    repository.save(new Tweet(tweet));
    return new ResponseEntity<>("OK", HttpStatus.CREATED);
  }

  public Page<Tweet> listTweets(int page) {
    int size = 5;
    Pageable filters = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
    return repository.findAll(filters);
  }

  public List<Tweet> listTweetsByUsername(String username) {
    return repository.findAllByUsername(username);
  }
}
