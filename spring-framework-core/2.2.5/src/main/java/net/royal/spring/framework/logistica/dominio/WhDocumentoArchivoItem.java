package net.royal.spring.framework.logistica.dominio;

import java.math.BigDecimal;
import java.util.List;

import net.royal.spring.framework.util.UString;

public class WhDocumentoArchivoItem {
	/*
	 * WH_DOCUMENTOARCHIVO.PK.COMPANIASOCIO
	 */
	private String companiasocio;
	
	/*
	 * WH_DOCUMENTOARCHIVO.PK.TIPODOCUMENTO
	 */
	private String tipodocumento;
	
	/*
	 * WH_DOCUMENTOARCHIVO.PK.NUMERODOCUMENTO
	 */
	private String numerodocumento;
	
	/*
	 * WH_DOCUMENTOARCHIVO.PK.SECUENCIA
	 */
	private BigDecimal secuencia;
	
	/*
	 * WH_DOCUMENTOARCHIVO.PK.LINEA
	 */
	private BigDecimal linea;
		
	private String archivo;
	private String comentario;
	private String idexterno;
	
	private String archivoString;
	private String archivoBase64;

	private String esNuevo;
	private String esModificado;
	private String esEliminado;

	private String descripcion;
	private String autor;
	private List<String> tags;
	private String titulo;
	
	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public BigDecimal getLinea() {
		return linea;
	}

	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}

	public BigDecimal getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(BigDecimal secuencia) {
		this.secuencia = secuencia;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getArchivoString() {
		return archivoString;
	}

	public void setArchivoString(String archivoString) {
		this.archivoString = archivoString;
	}

	public String getEsNuevo() {
		if (UString.esNuloVacio(esNuevo))
			esNuevo="N";
		return esNuevo;
	}

	public void setEsNuevo(String esNuevo) {
		this.esNuevo = esNuevo;
	}

	public String getEsModificado() {
		if (UString.esNuloVacio(esModificado))
			esModificado="N";
		return esModificado;
	}

	public void setEsModificado(String esModificado) {
		this.esModificado = esModificado;
	}

	public String getEsEliminado() {
		if (UString.esNuloVacio(esEliminado))
			esEliminado="N";
		return esEliminado;
	}

	public void setEsEliminado(String esEliminado) {
		this.esEliminado = esEliminado;
	}

	public String getIdexterno() {
		return idexterno;
	}

	public void setIdexterno(String idexterno) {
		this.idexterno = idexterno;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArchivoBase64() {
		return archivoBase64;
	}

	public void setArchivoBase64(String archivoBase64) {
		this.archivoBase64 = archivoBase64;
	}
	
}
