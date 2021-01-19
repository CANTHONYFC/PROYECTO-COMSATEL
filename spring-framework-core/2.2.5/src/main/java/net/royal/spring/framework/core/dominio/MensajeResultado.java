package net.royal.spring.framework.core.dominio;

import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.util.UString;

public class MensajeResultado {

	private Boolean flgValido;
	private List<MensajeUsuario> mensajes;

	public MensajeResultado() {
		flgValido = Boolean.FALSE;
		mensajes = new ArrayList<MensajeUsuario>();
	}

	public Boolean getFlgValido() {
		return flgValido;
	}

	public void setFlgValido(Boolean flgValido) {
		this.flgValido = flgValido;
	}

	public List<MensajeUsuario> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeUsuario> mensajes) {
		this.mensajes = mensajes;
	}

	public String getMensajesTexto() {
		String retorno = "";
		if (mensajes == null)
			mensajes = new ArrayList<>();
		for (MensajeUsuario mensajeUsuario : mensajes) {
			retorno = retorno + "\n" + UString.obtenerValorCadenaSinNulo(mensajeUsuario.getMensaje());
		}
		return retorno;
	}
}
