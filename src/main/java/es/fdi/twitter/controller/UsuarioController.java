package es.fdi.twitter.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService user_service;
	
    public UsuarioController() {
		super();
	}
    
    @ModelAttribute("user")
    public Usuario getUsuario(Usuario u){
    	return user_service.getUsuario(u);
    }
    
    @RequestMapping(value="/login")
    public String login(){
    	return "login";
    }
    
    @RequestMapping(value="/login", params={"entrar"})
	public String loguearse(Usuario u,BindingResult bindingResult, ModelMap model){
		if (bindingResult.hasErrors()) {
            return "welcome";
        }
		
		//this.user_service.addUsuario(u);
		//model.clear();
		
		return "redirect:/welcome";
	}
    
    @RequestMapping(value="/registro")
    public String registro(){
    	return "registro";
    }
    
    @RequestMapping(value="/registro", params={"registrar"})
	public String registrarse(Usuario u,BindingResult bindingResult, ModelMap model){
		if (bindingResult.hasErrors()) {
            return "welcome";
        }
		
		if(this.user_service.addUsuario(u)){
			model.clear();
			return "redirect:/registro.html?exito";
		}
		else{
			return "redirect:/registro?error";
		}
		
		
		
	}
    
}
