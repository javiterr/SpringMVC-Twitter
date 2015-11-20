package es.fdi.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.service.TweetService;
import es.fdi.twitter.service.UsuarioService;


@Controller
public class UsuarioController {

	private TweetService tweet_service;
	
	private UsuarioService user_service;
		
	
	@Autowired
    public UsuarioController(TweetService ts, UsuarioService us ) {
		tweet_service = ts;
    	user_service = us;
	}
    
    
    @RequestMapping(value="/login")
    public String login(){
    	return "login";
    }
    
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loguearse(Usuario u){
    	 	
    	Usuario user = user_service.getUsuario(u);
    	if(user != null){
    		user.setLogueado(true);
    		ModelAndView model = new ModelAndView("welcome");
    		model.addObject("allTweets", tweet_service.getLista());
    		model.addObject("userlogin", user);
    	    return model;	
    	}
    	else
    	    return new ModelAndView("login","error", "Usuario o contraseña incorrectos!!");
   
	}
    
    @RequestMapping(value="/registro")
    public String registro(){
    	return "registro";
    }
    
    
    @RequestMapping(value="/registro",  method=RequestMethod.POST)
    public ModelAndView registrar(Usuario u){
    	
    	ModelAndView model = new ModelAndView("registro");
    	if(user_service.addUsuario(u))
    	 model.addObject("exito", "Usuario registrado con éxito");
    	else
    	  model.addObject("error", "No se ha podido registrar el usuario");
    	
    	return model;
    	
    }
    
    
    @RequestMapping(value="/logout")
    public ModelAndView logout(){
    	
    	ModelAndView model = new ModelAndView("welcome");
    	Usuario user = user_service.getUsuarioLogueado();  	
    	user.setLogueado(false);
    
    	model.addObject("allTweets", tweet_service.getLista());
		model.addObject("userlogin", user);
		
	    return model;		
    		
    }
    
}
