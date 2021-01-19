package net.royal.spring.framework.core;

import java.util.ArrayList;
import java.util.List;

import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.util.UString;

public class UException extends Exception {

	private List<MensajeUsuario> errors;

	public List<MensajeUsuario> getErrors() {

		List<MensajeUsuario> lista = errors;

		if (lista == null) {
			lista = new ArrayList<MensajeUsuario>();
		}

		if (!UString.estaVacio(this.getMessage())) {
			MensajeUsuario mm = new MensajeUsuario();
			mm.setMensaje(this.getMessage());
			mm.setTipoMensaje(MensajeUsuario.tipo_mensaje.INFORMACION);

			boolean esta = false;

			for (MensajeUsuario mensajeUsuario : lista) {
				if (mensajeUsuario.getMensaje().equalsIgnoreCase(this.getMessage())) {
					esta = true;
				}
			}

			if (!esta) {
				lista.add(mm);
			}
		}

		return lista;
	}

	public void setErrors(List<MensajeUsuario> errors) {
		this.errors = errors;
	}

	public UException(List<MensajeUsuario> listaMensajeUsuario) {
		super(UValidador.concatenarArregloValidator(listaMensajeUsuario));
		this.errors = listaMensajeUsuario;
	}

	public UException(final String message) {
		super(message);
	}

	public UException() {
		super();
	}

	public UException(MensajeUsuario e) {
		super(e.getMensaje());
	}
	
}
