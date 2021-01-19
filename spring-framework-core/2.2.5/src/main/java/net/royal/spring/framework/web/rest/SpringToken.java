package net.royal.spring.framework.web.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.core.dominio.dto.Menu;

public class SpringToken implements Serializable {

	private static final long serialVersionUID = 1L;

	public SpringToken() {

	}

	public SpringToken(String token) {
		this.token = token;
	}

	private String token;
	private Menu menu;
	private List<MensajeUsuario> mensajes;
	private String flgCambiarClave;
	private UsuarioActual usuarioActual;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<MensajeUsuario> getMensajes() {
		if (mensajes==null)
			mensajes=new ArrayList();
		return mensajes;
	}

	public void setMensajes(List<MensajeUsuario> mensajes) {
		this.mensajes = mensajes;
	}

	public String getFlgCambiarClave() {
		return flgCambiarClave;
	}

	public void setFlgCambiarClave(String flgCambiarClave) {
		this.flgCambiarClave = flgCambiarClave;
	}

	public UsuarioActual getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(UsuarioActual usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
