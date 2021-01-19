package net.royal.spring.framework.core.dominio;

import net.royal.spring.framework.core.dominio.ConstanteDatos.TIPO_OPERACION;

public class ParametroPersistenciaGenerico implements java.io.Serializable {

	private static final long serialVersionUID = -1252253872796404022L;

	private String campo;
	private Class<?> clase;
	private transient Object valor;
	private TIPO_OPERACION operacion;

	public ParametroPersistenciaGenerico(String campo, Class<?> clase, Object valor) {
		this.campo = campo;
		this.clase = clase;
		this.valor = valor;
	}

	private ParametroPersistenciaGenerico(String campo, Object valor, TIPO_OPERACION operacion) {
		this.campo = campo;
		this.valor = valor;
		this.operacion = operacion;
	}

	public static ParametroPersistenciaGenerico crearParametroCriteria(String campo, Object valor) {
		return new ParametroPersistenciaGenerico(campo, valor, TIPO_OPERACION.EQ);
	}

	public static ParametroPersistenciaGenerico crearParametroCriteria(String campo, Object valor,
			TIPO_OPERACION operacion) {
		return new ParametroPersistenciaGenerico(campo, valor, operacion);
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public Class<?> getClase() {
		return clase;
	}

	public void setClase(Class<?> clase) {
		this.clase = clase;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public TIPO_OPERACION getOperacion() {
		return operacion;
	}

	public void setOperacion(TIPO_OPERACION operacion) {
		this.operacion = operacion;
	}
}
