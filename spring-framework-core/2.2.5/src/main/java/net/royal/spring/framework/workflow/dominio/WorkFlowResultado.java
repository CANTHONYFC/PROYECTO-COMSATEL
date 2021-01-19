package net.royal.spring.framework.workflow.dominio;

public class WorkFlowResultado {
	public static String ERROR = "ERROR";
	public static String OK = "OK";

	private String estado;
	private String mensaje;

	private String codigoproceso;
	private Integer transaccionid;

	private String accion;
	private String subaccion;

	public WorkFlowResultado() {
		estado = ERROR;
	}

	public WorkFlowResultado(String estado) {
		this.estado = estado;
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

	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}

	public Integer getTransaccionid() {
		return transaccionid;
	}

	public void setTransaccionid(Integer transaccionid) {
		this.transaccionid = transaccionid;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getSubaccion() {
		return subaccion;
	}

	public void setSubaccion(String subaccion) {
		this.subaccion = subaccion;
	}

}
