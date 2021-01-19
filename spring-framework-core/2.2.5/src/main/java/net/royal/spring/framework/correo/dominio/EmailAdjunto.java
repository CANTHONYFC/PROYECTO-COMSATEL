package net.royal.spring.framework.correo.dominio;

public class EmailAdjunto {

	private String nombreArchivo;
	private byte[] archivoAdjunto;
	private String rutaCompletaArchivo;
	private String archivoAdjuntoBase64;

	public EmailAdjunto() {
	}

	public EmailAdjunto(String nombreArchivo, byte[] archivoAdjunto) {
		this.nombreArchivo = nombreArchivo;
		this.archivoAdjunto = archivoAdjunto;
	}

	public EmailAdjunto(String nombreArchivo, String rutaCompletaArchivo, byte[] archivoAdjunto) {
		this.nombreArchivo = nombreArchivo;
		this.archivoAdjunto = archivoAdjunto;
		this.rutaCompletaArchivo = rutaCompletaArchivo;
	}

	public byte[] getArchivoAdjunto() {
		return archivoAdjunto;
	}

	public void setArchivoAdjunto(byte[] archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getRutaCompletaArchivo() {
		return rutaCompletaArchivo;
	}

	public void setRutaCompletaArchivo(String rutaCompletaArchivo) {
		this.rutaCompletaArchivo = rutaCompletaArchivo;
	}
	
	public String getArchivoAdjuntoBase64() {
		return archivoAdjuntoBase64;
	}

	public void setArchivoAdjuntoBase64(String archivoAdjuntoBase64) {
		this.archivoAdjuntoBase64 = archivoAdjuntoBase64;
	}

}
