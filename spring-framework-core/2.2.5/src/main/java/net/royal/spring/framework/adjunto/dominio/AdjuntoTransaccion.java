package net.royal.spring.framework.adjunto.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdjuntoTransaccion {
	public static String ERROR = "ERROR";
	public static String OK = "OK";

	public static Integer CONTENIDO_TIPO_FILESERVER = 1;
	public static Integer CONTENIDO_TIPO_BASEDATOS = 2;
	public static Integer CONTENIDO_TIPO_ALFRESCO = 3;

	private String estado;
	private String mensaje;
	private String cut;

	private String referenciaTipoRelacionId;
	private BigDecimal referenciaUnidadReplicacionId;
	private BigDecimal referenciaDocumentoId;
	private BigDecimal referenciaDocumentoDetalleId;
	private BigDecimal referenciaDocumentoSecuenciaId;

	/*
	 * Opcional 1 S(File Server), 2 B(Base de Datos), 3 A(Alfresco)
	 */
	private BigDecimal contenidoTipo;

	public String getCut() {
		return cut;
	}

	public void setCut(String cut) {
		this.cut = cut;
	}

	/*
	 * Opcional Carpeta en la que se guardara el archivo (Base de Datos/Alfresco)
	 */
	private String carpeta;

	private List<AdjuntoItem> listaArchivos;

	private String flgListaIniciada;

	public String getFlgListaIniciada() {
		return flgListaIniciada;
	}

	public void setFlgListaIniciada(String flgListaIniciada) {
		this.flgListaIniciada = flgListaIniciada;
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

	public String getReferenciaTipoRelacionId() {
		return referenciaTipoRelacionId;
	}

	public void setReferenciaTipoRelacionId(String referenciaTipoRelacionId) {
		this.referenciaTipoRelacionId = referenciaTipoRelacionId;
	}

	public BigDecimal getReferenciaUnidadReplicacionId() {
		return referenciaUnidadReplicacionId;
	}

	public void setReferenciaUnidadReplicacionId(BigDecimal referenciaUnidadReplicacionId) {
		this.referenciaUnidadReplicacionId = referenciaUnidadReplicacionId;
	}

	public BigDecimal getReferenciaDocumentoId() {
		return referenciaDocumentoId;
	}

	public void setReferenciaDocumentoId(BigDecimal referenciaDocumentoId) {
		this.referenciaDocumentoId = referenciaDocumentoId;
	}

	public BigDecimal getReferenciaDocumentoDetalleId() {
		return referenciaDocumentoDetalleId;
	}

	public void setReferenciaDocumentoDetalleId(BigDecimal referenciaDocumentoDetalleId) {
		this.referenciaDocumentoDetalleId = referenciaDocumentoDetalleId;
	}

	public BigDecimal getContenidoTipo() {
		return contenidoTipo;
	}

	public void setContenidoTipo(BigDecimal contenidoTipo) {
		this.contenidoTipo = contenidoTipo;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public List<AdjuntoItem> getListaArchivos() {
		if (listaArchivos == null)
			listaArchivos = new ArrayList<>();
		return listaArchivos;
	}

	public void setListaArchivos(List<AdjuntoItem> listaArchivos) {
		this.listaArchivos = listaArchivos;
	}

	public BigDecimal getReferenciaDocumentoSecuenciaId() {
		return referenciaDocumentoSecuenciaId;
	}

	public void setReferenciaDocumentoSecuenciaId(BigDecimal referenciaDocumentoSecuenciaId) {
		this.referenciaDocumentoSecuenciaId = referenciaDocumentoSecuenciaId;
	}

}
