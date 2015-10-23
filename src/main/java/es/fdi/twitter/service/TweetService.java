package es.fdi.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.entities.repositories.TweetRepository;

@Service
public class TweetService {

	@Autowired
	private TweetRepository tweet_repository;
	
	public TweetService(){
		super();
	}

	public List<Tweet> getLista() {
		return tweet_repository.getLista();
	}

	
	public void addTweet(Tweet t){
		tweet_repository.addTweet(t);
	}
	
}
