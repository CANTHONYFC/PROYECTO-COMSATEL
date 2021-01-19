package net.royal.spring.framework.core.dominio;

import java.io.Serializable;
import java.util.Date;

public class DominioGenerico implements Serializable {

	private static final long serialVersionUID = 3484299478568029874L;

	private String usuarioModificacion;
	private Date fechaModificacion;
	private String modificacionTerminal;

	private String usuarioCreacion;
	private Date fechaCreacion;
	private String creacionTerminal;

	private String modificacionUsuario;
	private Date modificacionFecha;

	private String creacionUsuario;
	private Date creacionFecha;

	private String ultimoUsuario;
	private Date ultimaFechaModif;

	public DominioGenerico() {
	}

	public DominioGenerico(String usuarioModificacion, Date fechaModificacion, String modificacionTerminal,
			String usuarioCreacion, Date fechaCreacion, String creacionTerminal, String modificacionUsuario,
			Date modificacionFecha, String creacionUsuario, Date creacionFecha) {
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
		this.modificacionTerminal = modificacionTerminal;
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.creacionTerminal = creacionTerminal;

		this.modificacionUsuario = modificacionUsuario;
		this.modificacionFecha = modificacionFecha;
		this.creacionUsuario = creacionUsuario;
		this.creacionFecha = creacionFecha;
	}

	public String getModificacionTerminal() {
		return modificacionTerminal;
	}

	public void setModificacionTerminal(String modificacionTerminal) {
		this.modificacionTerminal = modificacionTerminal;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCreacionTerminal() {
		return creacionTerminal;
	}

	public void setCreacionTerminal(String creacionTerminal) {
		this.creacionTerminal = creacionTerminal;
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

	public String getUltimoUsuario() {
		return ultimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		this.ultimoUsuario = ultimoUsuario;
	}

	public Date getUltimaFechaModif() {
		return ultimaFechaModif;
	}

	public void setUltimaFechaModif(Date ultimaFechaModif) {
		this.ultimaFechaModif = ultimaFechaModif;
	}

	public DominioGenerico obtenerAuditoria(DominioGenerico objtransaccion, UsuarioActual usuario) {
		objtransaccion.setUltimoUsuario(usuario.getUsuarioLogin());
		objtransaccion.setUltimaFechaModif(new Date());
		return objtransaccion;
	}
}
