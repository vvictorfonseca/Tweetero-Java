package com.example.tweetero.model;

import com.example.tweetero.dto.tweetDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tweets")
public class Tweet {

  public Tweet(tweetDto data) {
    this.username =  data.username();
    this.tweet =  data.tweet();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, length = 30)
  private String username;

  @Column(nullable = false, length = 280)
  private String tweet;
}
