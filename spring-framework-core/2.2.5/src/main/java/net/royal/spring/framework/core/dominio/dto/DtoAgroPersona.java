package net.royal.spring.framework.core.dominio.dto;

import java.math.BigDecimal;

public class DtoAgroPersona {
	
	/* PERSONA AGRO ID */
	private BigDecimal personaAgroId;
	
	/* PERSONA AGRO BUSQUEDA */
	private String busqueda;
	
	/* PERSONA AGRO DOCUMENTO */
	private String documento;
	
	/* PERSONA AGRO CORREO */
	private String correo;
	
	/* PERSONA AGRO CELULAR */
	private String celular;
	
	/* PERSONA AGRO TELEFONO */
	private String telefono;
	
	/* PERSONA AGRO DIRECCION */
	private String direccion;
	
	/* PERSONA AGRO ESTADO */
	private BigDecimal personaAgroEstado;
	
	/* PERSONA ERP ID */
	private BigDecimal personaErpId;
	
	/* PERSONA ERP TIPO DOCUMENTO */
	private String personaErpTipoDocumento;
	
	/* PRODUCTOR ID */
	private BigDecimal productorId;
	/* PRODUCTOR ESTADO */
	private BigDecimal productorEstado;
	
	/* PROVEEDOR ID */
	private BigDecimal provAgroId;
	/* PROVEEDOR ESTADO */
	private BigDecimal provAgroEstado;
	
	/* PERSONA CTI */
	private String  presonaagroactid;
	
	
	private String personaagrotelefono;
	private String personaagroubigeo;
	private String personaagrodireccion;
	private BigDecimal personaagrogislatitud;
	private BigDecimal personaagrogisnivelmar;
	private BigDecimal personaagronacionalidad;
	private BigDecimal personaagropais;
	private BigDecimal personaagrodocumentotipo;
	
	private String personaagroubigeodescripcion;
	
	private String transaccionEstado;
	private String transaccionMensaje;
	
	public String getPersonaagrotelefono() {
		return personaagrotelefono;
	}
	public void setPersonaagrotelefono(String personaagrotelefono) {
		this.personaagrotelefono = personaagrotelefono;
	}
	public String getPersonaagroubigeo() {
		return personaagroubigeo;
	}
	public void setPersonaagroubigeo(String personaagroubigeo) {
		this.personaagroubigeo = personaagroubigeo;
	}
	public String getPersonaagrodireccion() {
		return personaagrodireccion;
	}
	public void setPersonaagrodireccion(String personaagrodireccion) {
		this.personaagrodireccion = personaagrodireccion;
	}
	public BigDecimal getPersonaagrogislatitud() {
		return personaagrogislatitud;
	}
	public void setPersonaagrogislatitud(BigDecimal personaagrogislatitud) {
		this.personaagrogislatitud = personaagrogislatitud;
	}
	public BigDecimal getPersonaagrogisnivelmar() {
		return personaagrogisnivelmar;
	}
	public void setPersonaagrogisnivelmar(BigDecimal personaagrogisnivelmar) {
		this.personaagrogisnivelmar = personaagrogisnivelmar;
	}
	public BigDecimal getPersonaagronacionalidad() {
		return personaagronacionalidad;
	}
	public void setPersonaagronacionalidad(BigDecimal personaagronacionalidad) {
		this.personaagronacionalidad = personaagronacionalidad;
	}
	public BigDecimal getPersonaagropais() {
		return personaagropais;
	}
	public void setPersonaagropais(BigDecimal personaagropais) {
		this.personaagropais = personaagropais;
	}
	public BigDecimal getPersonaagrodocumentotipo() {
		return personaagrodocumentotipo;
	}
	public void setPersonaagrodocumentotipo(BigDecimal personaagrodocumentotipo) {
		this.personaagrodocumentotipo = personaagrodocumentotipo;
	}
	private BigDecimal ROWNUM_;
	
	public BigDecimal getPersonaAgroId() {
		return personaAgroId;
	}
	public void setPersonaAgroId(BigDecimal personaAgroId) {
		this.personaAgroId = personaAgroId;
	}
	public String getBusqueda() {
		return busqueda;
	}
	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public BigDecimal getPersonaAgroEstado() {
		return personaAgroEstado;
	}
	public void setPersonaAgroEstado(BigDecimal personaAgroEstado) {
		this.personaAgroEstado = personaAgroEstado;
	}
	public BigDecimal getPersonaErpId() {
		return personaErpId;
	}
	public void setPersonaErpId(BigDecimal personaErpId) {
		this.personaErpId = personaErpId;
	}
	public BigDecimal getProductorId() {
		return productorId;
	}
	public void setProductorId(BigDecimal productorId) {
		this.productorId = productorId;
	}
	public BigDecimal getProductorEstado() {
		return productorEstado;
	}
	public void setProductorEstado(BigDecimal productorEstado) {
		this.productorEstado = productorEstado;
	}
	public BigDecimal getProvAgroId() {
		return provAgroId;
	}
	public void setProvAgroId(BigDecimal provAgroId) {
		this.provAgroId = provAgroId;
	}
	public BigDecimal getProvAgroEstado() {
		return provAgroEstado;
	}
	public void setProvAgroEstado(BigDecimal provAgroEstado) {
		this.provAgroEstado = provAgroEstado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}
	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}
	public String getPersonaErpTipoDocumento() {
		return personaErpTipoDocumento;
	}
	public void setPersonaErpTipoDocumento(String personaErpTipoDocumento) {
		this.personaErpTipoDocumento = personaErpTipoDocumento;
	}
	public String getTransaccionEstado() {
		return transaccionEstado;
	}
	public void setTransaccionEstado(String transaccionEstado) {
		this.transaccionEstado = transaccionEstado;
	}
	public String getTransaccionMensaje() {
		return transaccionMensaje;
	}
	public void setTransaccionMensaje(String transaccionMensaje) {
		this.transaccionMensaje = transaccionMensaje;
	}
	public String getPersonaagroubigeodescripcion() {
		return personaagroubigeodescripcion;
	}
	public void setPersonaagroubigeodescripcion(String personaagroubigeodescripcion) {
		this.personaagroubigeodescripcion = personaagroubigeodescripcion;
	}
	public String getPresonaagroactid() {
		return presonaagroactid;
	}
	public void setPresonaagroactid(String presonaagroactid) {
		this.presonaagroactid = presonaagroactid;
	}

	
	
	
	
}
