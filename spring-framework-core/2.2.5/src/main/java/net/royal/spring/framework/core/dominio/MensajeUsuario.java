package net.royal.spring.framework.core.dominio;

import java.io.Serializable;

public class MensajeUsuario implements Serializable {
	/**
	 * 
	 */
	public enum tipo_mensaje {
	ERROR, ADVERTENCIA, EXITO, INFORMACION,PREGUNTA
	};

	private static final long serialVersionUID = -2801857163477327081L;
	private tipo_mensaje tipoMensaje;

	private String codigo;
	private String titulo;
	private String mensaje;
	private String fuente;
	private String solucion;

	public MensajeUsuario() {
	}

	public MensajeUsuario(tipo_mensaje tipoMensaje, String mensaje) {
		this.tipoMensaje = tipoMensaje;
		this.mensaje = mensaje;
	}

	public MensajeUsuario(tipo_mensaje tipoMensaje, String titulo, String mensaje) {
		this.tipoMensaje = tipoMensaje;
		this.titulo = titulo;
		this.mensaje = mensaje;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public tipo_mensaje getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(tipo_mensaje tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
