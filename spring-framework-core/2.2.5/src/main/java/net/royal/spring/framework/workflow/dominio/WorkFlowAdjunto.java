package net.royal.spring.framework.workflow.dominio;

public class WorkFlowAdjunto {
	private String nombre;
	private String flagver;
	private byte[] bytes;
	private String archivoAdjuntoBase64;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFlagver() {
		return flagver;
	}
	public void setFlagver(String flagver) {
		this.flagver = flagver;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public String getArchivoAdjuntoBase64() {
		return archivoAdjuntoBase64;
	}
	public void setArchivoAdjuntoBase64(String archivoAdjuntoBase64) {
		this.archivoAdjuntoBase64 = archivoAdjuntoBase64;
	}
	
}
