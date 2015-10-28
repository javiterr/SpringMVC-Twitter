package es.fdi.twitter.entities.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import es.fdi.twitter.entities.Usuario;

@Repository
public class UsuarioRepository {

	List<Usuario> lista_users = new ArrayList<Usuario>();
		
	public UsuarioRepository(){
		super();
	}
	
	public Usuario getUsuario(Usuario u){
		Usuario user = null;
		boolean encontrado = false;
		int i=0;
		
		while(!encontrado && (i < lista_users.size()) ){
			if(u.getUsername().equals(lista_users.get(i).getUsername()) 
					&& u.getPassword().equals(lista_users.get(i).getPassword())){
				encontrado = true;
				user = lista_users.get(i);
			}
			i++;
		}
		
		
		return user;
	}
	
	public boolean addUsuario(Usuario u){
		
		boolean exito = false;
		Usuario user = getUsuario(u);
		
		if(user == null){
			lista_users.add(u);
			exito = true;
		}
		
		return exito;
		
	}
}
