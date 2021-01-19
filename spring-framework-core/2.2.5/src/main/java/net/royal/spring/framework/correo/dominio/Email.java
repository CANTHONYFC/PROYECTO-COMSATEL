package net.royal.spring.framework.correo.dominio;

import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.core.UValidador;

public class Email {
	private String remitenteNombre;
	private String remitenteCorreo;
	private String asunto;
	private byte[] cuerpoCorreo;
	private String cuerpoCorreoBase64;
	
	private List<EmailDestino> listaCorreoDestino;
	private List<EmailAdjunto> listaCorreoAdjunto;

	private Boolean flgCorreoPrueba = Boolean.FALSE;

	public Email() {
		listaCorreoDestino = new ArrayList<EmailDestino>();
		listaCorreoAdjunto = new ArrayList<EmailAdjunto>();
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public byte[] getCuerpoCorreo() {
		return cuerpoCorreo;
	}

	public void setCuerpoCorreo(byte[] cuerpoCorreo) {
		this.cuerpoCorreo = cuerpoCorreo;
	}

	public List<EmailDestino> getListaCorreoDestino() {
		if (listaCorreoDestino == null)
			listaCorreoDestino = new ArrayList<EmailDestino>();
		return listaCorreoDestino;
	}

	public void setListaCorreoDestino(List<EmailDestino> listaCorreoDestino) {
		this.listaCorreoDestino = listaCorreoDestino;
	}

	public List<EmailAdjunto> getListaCorreoAdjunto() {
		if (UValidador.esListaVacia(listaCorreoAdjunto)) {
			listaCorreoAdjunto = new ArrayList<EmailAdjunto>();
		}
		return listaCorreoAdjunto;
	}

	public void setListaCorreoAdjunto(List<EmailAdjunto> listaCorreoAdjunto) {
		this.listaCorreoAdjunto = listaCorreoAdjunto;
	}


	public String getRemitenteNombre() {
		return remitenteNombre;
	}

	public void setRemitenteNombre(String remitenteNombre) {
		this.remitenteNombre = remitenteNombre;
	}

	public Boolean getFlgCorreoPrueba() {
		return flgCorreoPrueba;
	}

	public void setFlgCorreoPrueba(Boolean flgCorreoPrueba) {
		this.flgCorreoPrueba = flgCorreoPrueba;
	}

	public String getRemitenteCorreo() {
		return remitenteCorreo;
	}

	public void setRemitenteCorreo(String remitenteCorreo) {
		this.remitenteCorreo = remitenteCorreo;
	}

	public String getCuerpoCorreoBase64() {
		return cuerpoCorreoBase64;
	}

	public void setCuerpoCorreoBase64(String cuerpoCorreoBase64) {
		this.cuerpoCorreoBase64 = cuerpoCorreoBase64;
	}

}
