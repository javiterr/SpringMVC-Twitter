package es.fdi.twitter.controller;


import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.service.TweetService;
import es.fdi.twitter.service.UsuarioService;


@Controller
public class TweetController {

	@Autowired
	private TweetService tweet_service;
	
	@Autowired
	private UsuarioService user_service;
	
    public TweetController() {
		super();
	}
	
    @ModelAttribute("userlogin")
    public Usuario getUserLog(){
    	return user_service.getUsuarioLogueado();
    }
    
    @ModelAttribute("allTweets")
    public List<Tweet> listaDeTweets() {
        return this.tweet_service.getLista();
    }
    
	
	
    @RequestMapping({"/","/welcome"})
    public String showTweets(Tweet t) {
        return "welcome";
    }
    
    
	@RequestMapping(value="/welcome", params={"publicar"})
	public String publicar(@ModelAttribute("userlogin") Usuario u,Tweet t, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            return "welcome";
        }
		t.setFecha(Calendar.getInstance().getTime());
		t.setUsuario(u);
		this.tweet_service.addTweet(t);
		
		
		return "redirect:/welcome";
	}
	
	
}
