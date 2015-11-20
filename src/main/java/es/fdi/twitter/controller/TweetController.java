package es.fdi.twitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.service.TweetService;
import es.fdi.twitter.service.UsuarioService;


@Controller
public class TweetController {

	//Javi
	
	
	
	
	
	public void fff(){
	}
	
	
	
	
	private TweetService tweet_service;
	
	private UsuarioService user_service;
	
	@Autowired
    public TweetController(TweetService ts, UsuarioService us ) {
    	tweet_service = ts;
    	user_service = us;
	}
	
	
    @RequestMapping({"/","/welcome"})
    public ModelAndView showTweets() {
        return new ModelAndView("welcome","userlogin",new Usuario());
    }
    
    
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public ModelAndView publicar(Tweet t){
		
		Usuario u = user_service.getUsuarioLogueado();
		this.tweet_service.addTweet(t, u);
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("userlogin", u);
		model.addObject("allTweets", tweet_service.getLista());
		
		return model;
	}
	
	
}
