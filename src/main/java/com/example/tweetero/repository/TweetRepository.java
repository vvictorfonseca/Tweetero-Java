package com.example.tweetero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tweetero.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
  List<Tweet> findAllByUsername(String username);
}
