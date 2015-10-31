package es.fdi.twitter.entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Tweet {

	private Integer id = null;
	private String msg = null;;
	private Date fecha = null;
	@Autowired
	private Usuario usuario = null;
	

	public Tweet(){
		super();
	}
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
