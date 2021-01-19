package net.royal.spring.framework.core.dominio;

import java.math.BigDecimal;
import java.util.Date;

public class TipoCambioTransaccion {
	public static String ERROR = "ERROR";
	public static String OK = "OK";
	
	private String estado;
	private String mensaje;
	
	private Date fecha;
	private String tipo;
	private BigDecimal tipoCambio;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
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
