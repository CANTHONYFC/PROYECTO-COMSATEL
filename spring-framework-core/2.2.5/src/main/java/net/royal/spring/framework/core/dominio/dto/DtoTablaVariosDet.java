package net.royal.spring.framework.core.dominio.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DtoTablaVariosDet {
	private BigDecimal tablaId;
	private String tablaCodigo;
	
	private BigDecimal linea;	
	private String nemonico;
	private String descripcion;
	private Date valorFecha;
	private BigDecimal valorNumerico;
	private String valorTexto;
	private BigDecimal estado;	
	
	public BigDecimal getTablaId() {
		return tablaId;
	}
	public void setTablaId(BigDecimal tablaId) {
		this.tablaId = tablaId;
	}
	public String getTablaCodigo() {
		return tablaCodigo;
	}
	public void setTablaCodigo(String tablaCodigo) {
		this.tablaCodigo = tablaCodigo;
	}
	public BigDecimal getLinea() {
		return linea;
	}
	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}
	public String getNemonico() {
		return nemonico;
	}
	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getValorFecha() {
		return valorFecha;
	}
	public void setValorFecha(Date valorFecha) {
		this.valorFecha = valorFecha;
	}
	public BigDecimal getValorNumerico() {
		return valorNumerico;
	}
	public void setValorNumerico(BigDecimal valorNumerico) {
		this.valorNumerico = valorNumerico;
	}
	public String getValorTexto() {
		return valorTexto;
	}
	public void setValorTexto(String valorTexto) {
		this.valorTexto = valorTexto;
	}
	public BigDecimal getEstado() {
		return estado;
	}
	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}	
}
