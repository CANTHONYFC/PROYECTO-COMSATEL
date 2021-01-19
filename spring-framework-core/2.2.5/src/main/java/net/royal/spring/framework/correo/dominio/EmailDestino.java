package net.royal.spring.framework.correo.dominio;

import net.royal.spring.framework.correo.constante.ConstanteEmail.tipo_destino;

public class EmailDestino {

	private tipo_destino destino;

	private String correoDestino;

	public EmailDestino() {
	}

	public EmailDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public String getCorreoDestino() {
		return correoDestino;
	}

	public void setCorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public tipo_destino getDestino() {
		return destino;
	}

	public void setDestino(tipo_destino destino) {
		this.destino = destino;
	}
}
