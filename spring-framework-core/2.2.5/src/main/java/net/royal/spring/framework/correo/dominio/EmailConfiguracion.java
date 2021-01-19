package net.royal.spring.framework.correo.dominio;

import java.util.Properties;

import javax.mail.Session;

import net.royal.spring.framework.util.UBoolean;
import net.royal.spring.framework.util.UString;

public class EmailConfiguracion {
	private Session sessionCorreo;

	/**
	 * CLASE o BASE DATOS
	 */
	private String tipoConfiguracion;

	// PARA LA REALIZACION DE LAS PRUEBAS
	private String flgCorreoPrueba;
	private String correoPrueba;

	// CONFIGURACIONS DEL SERVIDOR
	private String emailRemitente;
	private String emailCuenta;
	private String emailClave;
	private String emailPerfil;
	private String rutaRaizAdjuntos;

	private String emailServidor;
	private String emailPuerto;
	private String emailFlgSsl;
	private String emailFlgCredenciales;

	/**
	 * devolviendo los resultados
	 */
	/*private Boolean flgResultadoEnvioCorreo;
	private String mensajeEnvioCorreo;*/

	public String getEmailPerfil() {
		return emailPerfil;
	}

	public void setEmailPerfil(String emailPerfil) {
		this.emailPerfil = emailPerfil;
	}

	public String getEmailCuenta() {
		return emailCuenta;
	}

	public void setEmailCuenta(String emailCuenta) {
		this.emailCuenta = emailCuenta;
	}

	public String getEmailClave() {
		return emailClave;
	}

	public void setEmailClave(String emailClave) {
		this.emailClave = emailClave;
	}

	public String getFlgCorreoPrueba() {
		return flgCorreoPrueba;
	}

	public void setFlgCorreoPrueba(String flgCorreoPrueba) {
		this.flgCorreoPrueba = flgCorreoPrueba;
	}

	public String getCorreoPrueba() {
		return correoPrueba;
	}

	public void setCorreoPrueba(String correoPrueba) {
		this.correoPrueba = correoPrueba;
	}

	public Session getSessionCorreo() {
		return sessionCorreo;
	}

	public void setSessionCorreo(Session sessionCorreo) {
		this.sessionCorreo = sessionCorreo;
	}

	public String getRutaRaizAdjuntos() {
		return rutaRaizAdjuntos;
	}

	public void setRutaRaizAdjuntos(String rutaRaizAdjuntos) {
		this.rutaRaizAdjuntos = rutaRaizAdjuntos;
	}


	public String getTipoConfiguracion() {
		return tipoConfiguracion;
	}

	public void setTipoConfiguracion(String tipoConfiguracion) {
		this.tipoConfiguracion = tipoConfiguracion;
	}

	public String getEmailRemitente() {
		return emailRemitente;
	}

	public void setEmailRemitente(String emailRemitente) {
		this.emailRemitente = emailRemitente;
	}

	public String getEmailServidor() {
		return emailServidor;
	}

	public void setEmailServidor(String emailServidor) {
		this.emailServidor = emailServidor;
	}

	public String getEmailPuerto() {
		return emailPuerto;
	}

	public void setEmailPuerto(String emailPuerto) {
		this.emailPuerto = emailPuerto;
	}

	public String getEmailFlgSsl() {
		return emailFlgSsl;
	}

	public void setEmailFlgSsl(String emailFlgSsl) {
		this.emailFlgSsl = emailFlgSsl;
	}

	public String getEmailFlgCredenciales() {
		return emailFlgCredenciales;
	}

	public void setEmailFlgCredenciales(String emailFlgCredenciales) {
		this.emailFlgCredenciales = emailFlgCredenciales;
	}

	public EmailConfiguracion prepararConfiguracion() {
		Properties pro = new Properties();

		if (!UString.estaVacio(emailFlgSsl))
			pro.put("mail.smtp.starttls.enable", UBoolean.obtenerNombreValorIngles(emailFlgSsl));

		if (!UString.estaVacio(emailServidor))
			pro.put("mail.smtp.host", emailServidor);

		if (!UString.estaVacio(emailPuerto))
			pro.put("mail.smtp.port", emailPuerto);

		if (!UString.estaVacio(emailFlgCredenciales))
			pro.put("mail.smtp.auth", UBoolean.obtenerNombreValorIngles(emailFlgCredenciales));

		if (!UString.estaVacio(emailCuenta))
			pro.put("mail.user", emailCuenta);

		if (!UString.estaVacio(emailClave))
			pro.put("mail.password", emailClave);

		if (!UString.estaVacio(emailRemitente))
			pro.put("mail.smtp.mail.sender", emailRemitente);

		//System.out.println("prepararConfiguracion");
		//System.out.println(pro);
		
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(pro);
		this.setSessionCorreo(session);

		return this;
	}

}
