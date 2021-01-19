package net.royal.spring.framework.reporte.dominio;

public class ReporteResultado {
	public static String ERROR="ERROR";
	public static String OK="OK";
	
	private String estado;
	private String mensaje;
	
	private String asunto;
	private byte[] reporteCuerpo;
	private String reporteCuerpoCadena;
	
	public ReporteResultado() {
		estado=ERROR;
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

	public byte[] getReporteCuerpo() {
		return reporteCuerpo;
	}

	public void setReporteCuerpo(byte[] reporteCuerpo) {
		this.reporteCuerpo = reporteCuerpo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getReporteCuerpoCadena() {
		return reporteCuerpoCadena;
	}

	public void setReporteCuerpoCadena(String reporteCuerpoCadena) {
		this.reporteCuerpoCadena = reporteCuerpoCadena;
	}
	
}
