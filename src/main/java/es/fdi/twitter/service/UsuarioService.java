package es.fdi.twitter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.fdi.twitter.entities.Usuario;
import es.fdi.twitter.entities.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository user_repository;
	
	public UsuarioService(){
		super();
	}

	public Usuario getUsuario(Usuario u){
		return user_repository.getUsuario(u);
	}
	
	public Usuario getUsuarioLogueado(){
		return user_repository.getUsuarioLogueado();
	}

	
	public boolean addUsuario(Usuario u){
		return user_repository.addUsuario(u);
	}
}
