package net.royal.spring.framework.core.dominio;

import java.io.File;
import java.net.URLConnection;

public class DominioArchivo {
	private String mimeType;
	private String rutaCompleta;
	private String nombre;
	private byte[] archivo;
	private File archivoFile;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getRutaCompleta() {
		return rutaCompleta;
	}
	public void setRutaCompleta(String rutaCompleta) {
		this.rutaCompleta = rutaCompleta;
	}
	public File getArchivoFile() {
		return archivoFile;
	}
	public void setArchivoFile(File archivoFile) {
		this.archivoFile = archivoFile;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public void obtenerMimeType() {
		if (archivoFile!=null)
			this.mimeType = URLConnection.guessContentTypeFromName(archivoFile.getName());
		if (mimeType == null) {
			mimeType = "application/vnd.ms-excel;charset=UTF-8";
		}
	}
}
