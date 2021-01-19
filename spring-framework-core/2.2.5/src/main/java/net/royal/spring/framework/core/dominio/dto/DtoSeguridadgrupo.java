package net.royal.spring.framework.core.dominio.dto;

import java.util.List;

public class DtoSeguridadgrupo {
	private String descripcion;
	private String aplicacioncodigo;
	private String grupo;
	private String concepto;
	
	private List<DtoSeguridadconcepto> conceptos;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAplicacioncodigo() {
		return aplicacioncodigo;
	}
	public void setAplicacioncodigo(String aplicacioncodigo) {
		this.aplicacioncodigo = aplicacioncodigo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public List<DtoSeguridadconcepto> getConceptos() {
		return conceptos;
	}
	public void setConceptos(List<DtoSeguridadconcepto> conceptos) {
		this.conceptos = conceptos;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
}
