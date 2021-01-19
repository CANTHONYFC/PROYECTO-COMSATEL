package net.royal.spring.framework.logistica.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WhDocumentoArchivoTransaccion {
	public static String ERROR="ERROR";
	public static String OK="OK";
	public static String TIPO_ALFRESCO="A";
	public static String TIPO_FILESERVER="S";
	public static String TIPO_BASEDATOS="B";
	
	private String estado;
	private String mensaje;
	
	/*
	 * Opcional
	 * S(File Server), B(Base de Datos), A(Alfresco)
	 */
	private String tipoAlmacen;
	/*
	 * Opcional
	 * Carpeta en la que se guardara el archivo (Base de Datos/Alfresco)
	 */
	private String carpeta;
	
	private String companiasocio;
	private String tipodocumento;
	private String numerodocumento;
	private BigDecimal linea;
	
	private List<WhDocumentoArchivoItem> listaArchivos;

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	
	public BigDecimal getLinea() {
		return linea;
	}

	public void setLinea(BigDecimal linea) {
		this.linea = linea;
	}

	public List<WhDocumentoArchivoItem> getListaArchivos() {
		if (listaArchivos==null)
			listaArchivos=new ArrayList<WhDocumentoArchivoItem>();
		return listaArchivos;
	}

	public void setListaArchivos(List<WhDocumentoArchivoItem> listaArchivos) {
		this.listaArchivos = listaArchivos;
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

	/**
	 * Opcional
	 * S(File Server), B(Base de Datos), A(Alfresco)
	 */
	public String getTipoAlmacen() {
		return tipoAlmacen;
	}

	/**
	 * Opcional
	 * S(File Server), B(Base de Datos), A(Alfresco)
	 */
	public void setTipoAlmacen(String tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}
	/*
	 * Opcional
	 * Carpeta en la que se guardara el archivo (Base de Datos/Alfresco)
	 */
	public String getCarpeta() {
		return carpeta;
	}
	/*
	 * Opcional
	 * Carpeta en la que se guardara el archivo (Base de Datos/Alfresco)
	 */
	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}	
	
}
