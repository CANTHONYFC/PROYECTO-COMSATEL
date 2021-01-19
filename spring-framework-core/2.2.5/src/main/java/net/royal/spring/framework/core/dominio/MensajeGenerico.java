package net.royal.spring.framework.core.dominio;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MensajeGenerico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -498639708887756775L;

	private List<Object> valores;
	private Object valor;
	private String accionTag;
	private ParametroListaGenerico parametros;

	public MensajeGenerico() {
		super();
		parametros = new ParametroListaGenerico();
	}

	public MensajeGenerico(String accionTag, List<Object> valores, Object valor) {
		super();
		parametros = new ParametroListaGenerico();
		this.valores = valores;
		this.accionTag = accionTag;
		this.valor = valor;
	}

	/**
	 * devuelve la accion o identificador a realizarse
	 * 
	 * @return accionTag tipo String que identifica la accion a realizarse
	 */
	public String getAccionTag() {
		return accionTag;
	}

	/**
	 * asigna la accion o identificador unico que identifica al proceso
	 * 
	 * @param accionTag tipo String que identifica la accion a realizarse
	 */
	public void setAccionTag(String accionTag) {
		this.accionTag = accionTag;
	}

	/**
	 * Devuelve un conjunto de parametros enviado como parte del mensaje Si desea
	 * devolver un solo parametro ver <strong>getValor</strong>
	 * 
	 * @return devuelve un List<Object>
	 */
	public List<Object> getValores() {
		return valores;
	}

	/**
	 * Asignacion de parametros que se envia como parte del mensaje. Si desea enviar
	 * un solo parametro ver <strong>setValor</strong>
	 * 
	 * @param parametro del tipo List<Object>
	 */
	public void setValores(List<Object> valores) {
		this.valores = valores;
	}

	/**
	 * Devuelve un unico parametro enviado como parte del mensaje Si desea devolver
	 * mas de un parametro ver <strong>getValores</strong>
	 * 
	 * @return devuelve un Object
	 */
	public Object getValor() {
		return valor;
	}

	/**
	 * Asignacion de parametro que se envia como parte del mensaje. Si desea enviar
	 * mas de un parametro ver <strong>setValores</strong>
	 * 
	 * @param parametro del tipo Object
	 */
	public void setValor(Object valor) {
		this.valor = valor;
	}

	public ParametroListaGenerico getParametros() {
		return parametros;
	}

	public void setParametros(ParametroListaGenerico parametros) {
		this.parametros = parametros;
	}

	public void setParametros(Map<String, Object> parametros) {
		if (this.parametros == null)
			this.parametros = new ParametroListaGenerico();
		if (parametros == null)
			return;

		Iterator<String> it = parametros.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			this.parametros.parametroAgregar(key, null, parametros.get(key));
		}

	}

}
