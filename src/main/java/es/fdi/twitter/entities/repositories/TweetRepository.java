package es.fdi.twitter.entities.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Repository;
import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.entities.Usuario;

@Repository
public class TweetRepository {

	List<Tweet> lista_tweets = new ArrayList<Tweet>();
	
	public TweetRepository(){
		super();
	}
	
	public List<Tweet> getLista(){
		return new ArrayList<Tweet>(lista_tweets);
	}
	
	public void addTweet(Tweet t, Usuario u){
		t.setFecha(Calendar.getInstance().getTime());
		t.setUsuario(u);
		lista_tweets.add(t);
	}
	
}
