package net.royal.spring.framework.core.dominio;

import net.royal.spring.framework.util.UString;

public class UsuarioSeguridad {
	private String clienteCodigo;
	
	/**
	 * informacion del correo interno o principal con al cual se puede trabajar en
	 * todo el sistema
	 */
	private String usuarioCorreoInterno;
	
	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla Usuario
	 */
	private String usuarioLogin;
	
	private String usuarioClave;
	
	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	private String companiaSocioCodigo;
	private String companiaSocioNombre;
	
	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	private String usuarioHostName;

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la aplicacion
	 */
	private String usuarioIpAddress;
	
	private String aplicacionCodigo;
	private String aplicacionNombre;
	
	private String tokenCliente;
	
	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla Usuario
	 */
	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	/**
	 * login o usuario con el que ingreso al sistema esto viene de la tabla Usuario
	 */
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	
	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public String getUsuarioHostName() {
		return usuarioHostName;
	}

	/**
	 * indica cual es el nombre de la pc desde la cual se ha ingresado a la
	 * aplicacion
	 */
	public void setUsuarioHostName(String usuarioHostName) {
		this.usuarioHostName = usuarioHostName;
	}

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la aplicacion
	 */
	public String getUsuarioIpAddress() {
		return usuarioIpAddress;
	}

	/**
	 * indica cual es la direcion ip desde la cual se ha ingresado a la aplicacion
	 */
	public void setUsuarioIpAddress(String usuarioIpAddress) {
		this.usuarioIpAddress = usuarioIpAddress;
	}
	
	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public String getCompaniaSocioCodigo() {
		if (UString.esNuloVacio(companiaSocioCodigo))
			companiaSocioCodigo="";
		return companiaSocioCodigo;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public void setCompaniaSocioCodigo(String companiaSocioCodigo) {
		this.companiaSocioCodigo = companiaSocioCodigo;
	}
	
	/**
	 * informacion del correo interno o principal con al cual se puede trabajar en
	 * todo el sistema
	 */
	public String getUsuarioCorreoInterno() {
		return usuarioCorreoInterno;
	}

	/**
	 * informacion del correo interno o principal con al cual se puede trabajar en
	 * todo el sistema
	 */
	public void setUsuarioCorreoInterno(String usuarioCorreoInterno) {
		this.usuarioCorreoInterno = usuarioCorreoInterno;
	}
	
	public String getAplicacionCodigo() {
		return aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	public String getAplicacionNombre() {
		return aplicacionNombre;
	}

	public void setAplicacionNombre(String aplicacionNombre) {
		this.aplicacionNombre = aplicacionNombre;
	}
	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public String getCompaniaSocioNombre() {
		return companiaSocioNombre;
	}

	/**
	 * empleadomast.companiasocio = COMPANYOWNER.COMPANYOWNER
	 * 
	 * @return
	 */
	public void setCompaniaSocioNombre(String companiaSocioNombre) {
		this.companiaSocioNombre = companiaSocioNombre;
	}

	public String getClienteCodigo() {
		return clienteCodigo;
	}

	public void setClienteCodigo(String clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
	}

	public String getUsuarioClave() {
		return usuarioClave;
	}

	public void setUsuarioClave(String usuarioClave) {
		this.usuarioClave = usuarioClave;
	}

	public String getTokenCliente() {
		return tokenCliente;
	}

	public void setTokenCliente(String tokenCliente) {
		this.tokenCliente = tokenCliente;
	}		
}

