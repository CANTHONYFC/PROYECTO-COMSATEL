package net.royal.spring.framework.adjunto.dominio;

public class AdjuntoClonar {
	private String estado;
	private String mensaje;
	
	public static String ERROR = "ERROR";
	public static String OK = "OK";
	
	private AdjuntoTransaccion origen;
	private AdjuntoTransaccion destino;
	
	public AdjuntoTransaccion getOrigen() {
		return origen;
	}
	public void setOrigen(AdjuntoTransaccion origen) {
		this.origen = origen;
	}
	public AdjuntoTransaccion getDestino() {
		return destino;
	}
	public void setDestino(AdjuntoTransaccion destino) {
		this.destino = destino;
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
	
}
