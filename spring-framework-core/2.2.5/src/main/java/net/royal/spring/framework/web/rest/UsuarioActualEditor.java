package net.royal.spring.framework.web.rest;

import java.beans.PropertyEditorSupport;

import org.json.JSONException;
import org.json.JSONObject;

import net.royal.spring.framework.core.dominio.UsuarioActual;

public class UsuarioActualEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		UsuarioActual exoticType = new UsuarioActual();

		try {
			JSONObject obj = new JSONObject(text);

			exoticType.setPersonaNombreCompleto(obj.getString("personaNombreCompleto"));
			exoticType.setAplicacionNombre(obj.getString("usuarioLogin"));
			exoticType.setCompaniaSocioCodigo(obj.getString("companiaSocioCodigo"));
			//exoticType.setPersonaId(obj.getInt("personaId"));

		} catch (JSONException e) {
			e.printStackTrace();
		}

		setValue(exoticType);
	}
}