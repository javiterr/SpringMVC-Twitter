package es.fdi.twitter.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService user_service;
	
    public UsuarioController() {
		super();
	}
    
    
    @RequestMapping(value="/login")
    public String login(){
    	return "login";
    }
    
    @RequestMapping(value="/login", params={"entrar"})
	public ModelAndView loguearse(Usuario u){
    	 	
    	Usuario user = user_service.getUsuario(u);
    	if(user != null){
    		user.setLogueado(true);
    	    return new ModelAndView("welcome","userlogin", user);	
    	}
    	else
    	    return new ModelAndView("login","error", "Usuario o contraseña incorrectos!!");
   
	}
    
    @RequestMapping(value="/registro")
    public String registro(){
    	return "registro";
    }
    
    
    @RequestMapping(value="/registro", params={"registrar"})
    public ModelAndView registrar(Usuario u){
    	
    	ModelAndView model = new ModelAndView("registro");
    	if(user_service.addUsuario(u))
    	 model.addObject("exito", "Usuario registrado con éxito");
    	else
    	  model.addObject("error", "No se ha podido registrar el usuario");
    	
    	return model;
    	
    }
    
}
