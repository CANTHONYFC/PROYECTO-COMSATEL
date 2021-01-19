package net.royal.spring.framework.correo.dominio;

public class EmailResultado {
	public static String ERROR="ERROR";
	public static String OK="OK";
	
	private String estado;
	private String mensaje;
	
	public EmailResultado() {
		estado=ERROR;
	}
	public EmailResultado(String estado) {		
		this.estado=estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
