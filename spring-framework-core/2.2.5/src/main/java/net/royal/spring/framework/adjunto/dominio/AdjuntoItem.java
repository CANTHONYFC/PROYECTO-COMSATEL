package net.royal.spring.framework.adjunto.dominio;

import java.math.BigDecimal;
import java.util.Date;

import net.royal.spring.framework.util.UBoolean;
import net.royal.spring.framework.util.UString;

public class AdjuntoItem {
	/*
	 * Opcional
	 * 1 S(File Server), 2 B(Base de Datos), 3 A(Alfresco)
	 */	
	private BigDecimal contenidoTipo;
	
	/*
	 * PK.ADJID
	 */
	private BigDecimal documentoId;
	
	/*
	 * ADJREFTIPORELACION
	 */
	private String referenciaTipoRelacionId;
	
	/*
	 * PK.ADJUNIDADREPID
	 */
	private BigDecimal referenciaUnidadReplicacionId;
	
	/*
	 * ADJREFDOCID
	 */
	private BigDecimal referenciaDocumentoId;
	
	/*
	 * ADJREFDOCLINEA
	 */
	private BigDecimal referenciaDocumentoDetalleId;
	
	/*
	 * ADJREFDOCSEC
	 */
	private BigDecimal referenciaDocumentoSecuenciaId;
	
	
	private String nombre;
	
	private String comentario;
	
	private String titulo;
	
	private String autor;
	
	private String tags;
	
	private String referencia2Tipo;
	
	private String referencia2Numero;
	
	private String rutaTemporal;
	
	private BigDecimal confidencial;
	
	private String archivoString;
	private String archivoBase64;
	private byte[] archivoByte;

	private String flgEliminar;
	private String flgNuevo;
	private String flgModificar;
	
	private String creacionUsuario;
	private Date creacionFecha;
	
	private String modificacionUsuario;
	private Date modificacionFecha;
	
	private String cut;
		
	public String getCut() {
		return cut;
	}
	public void setCut(String cut) {
		this.cut = cut;
	}
	public BigDecimal getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(BigDecimal documentoId) {
		this.documentoId = documentoId;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getArchivoString() {
		return archivoString;
	}
	public void setArchivoString(String archivoString) {
		this.archivoString = archivoString;
	}
	public String getArchivoBase64() {
		return archivoBase64;
	}
	public void setArchivoBase64(String archivoBase64) {
		this.archivoBase64 = archivoBase64;
	}
	
	public String getRutaTemporal() {
		return rutaTemporal;
	}
	public void setRutaTemporal(String rutaTemporal) {
		this.rutaTemporal = rutaTemporal;
	}
	public String getReferencia2Tipo() {
		return referencia2Tipo;
	}
	public void setReferencia2Tipo(String referencia2Tipo) {
		this.referencia2Tipo = referencia2Tipo;
	}
	public String getReferencia2Numero() {
		return referencia2Numero;
	}
	public void setReferencia2Numero(String referencia2Numero) {
		this.referencia2Numero = referencia2Numero;
	}
	
	
	public byte[] getArchivoByte() {
		return archivoByte;
	}
	public void setArchivoByte(byte[] archivoByte) {
		this.archivoByte = archivoByte;
	}
	public String getFlgEliminar() {
		if (UString.esNuloVacio(flgEliminar))
			flgEliminar="N";
		return flgEliminar;
	}
	public void setFlgEliminar(String flgEliminar) {
		this.flgEliminar = flgEliminar;
	}
	public String getFlgNuevo() {
		if (UString.esNuloVacio(flgNuevo))
			flgNuevo="N";
		return flgNuevo;
	}
	public void setFlgNuevo(String flgNuevo) {
		this.flgNuevo = flgNuevo;
	}
	public String getFlgModificar() {
		if (UString.esNuloVacio(flgModificar))
			flgModificar="N";
		return flgModificar;
	}
	public void setFlgModificar(String flgModificar) {
		this.flgModificar = flgModificar;
	}
	
	
	
	public BigDecimal getContenidoTipo() {
		return contenidoTipo;
	}
	public void setContenidoTipo(BigDecimal contenidoTipo) {
		this.contenidoTipo = contenidoTipo;
	}
	public Boolean getFlgNuevoBoolean() {
		return UBoolean.validarFlag(flgNuevo);
	}
	public Boolean getFlgModificarBoolean() {
		return UBoolean.validarFlag(flgModificar);
	}
	public Boolean getFlgEliminarBoolean() {
		return UBoolean.validarFlag(flgEliminar);
	}
	public BigDecimal getConfidencial() {
		return confidencial;
	}
	public void setConfidencial(BigDecimal confidencial) {
		this.confidencial = confidencial;
	}
	public String getModificacionUsuario() {
		return modificacionUsuario;
	}
	public void setModificacionUsuario(String modificacionUsuario) {
		this.modificacionUsuario = modificacionUsuario;
	}
	public Date getModificacionFecha() {
		return modificacionFecha;
	}
	public void setModificacionFecha(Date modificacionFecha) {
		this.modificacionFecha = modificacionFecha;
	}
	public String getCreacionUsuario() {
		return creacionUsuario;
	}
	public void setCreacionUsuario(String creacionUsuario) {
		this.creacionUsuario = creacionUsuario;
	}
	public Date getCreacionFecha() {
		return creacionFecha;
	}
	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}
	public BigDecimal getReferenciaDocumentoSecuenciaId() {
		return referenciaDocumentoSecuenciaId;
	}
	public void setReferenciaDocumentoSecuenciaId(BigDecimal referenciaDocumentoSecuenciaId) {
		this.referenciaDocumentoSecuenciaId = referenciaDocumentoSecuenciaId;
	}
	
}
