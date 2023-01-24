package com.example.tweetero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tweetero.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  
}
