package net.royal.spring.framework.core.dominio.dto;

import java.math.BigDecimal;

public class DtoAgroUbicacionGis {
	private BigDecimal latitud;
	private BigDecimal longitud;
	private BigDecimal puntos;
	private BigDecimal nivelMar;
	
	
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	public BigDecimal getPuntos() {
		return puntos;
	}
	public void setPuntos(BigDecimal puntos) {
		this.puntos = puntos;
	}
	public BigDecimal getNivelMar() {
		return nivelMar;
	}
	public void setNivelMar(BigDecimal nivelMar) {
		this.nivelMar = nivelMar;
	}	
}
