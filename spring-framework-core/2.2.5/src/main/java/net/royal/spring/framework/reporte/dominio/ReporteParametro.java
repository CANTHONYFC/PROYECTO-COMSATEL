package net.royal.spring.framework.reporte.dominio;

import java.util.HashMap;
import java.util.Map;

import net.royal.spring.framework.util.UString;

public class ReporteParametro {
	private String aplicacionCodigo;
	private String reporteCodigo;
	
	private String companiaSocio;
	private String periodo;
	private String version;
	
	private Map parametros;

	public String getNombreCompletoReporte(){
		String msgRetorno="";
		
		if (UString.estaVacio(companiaSocio))
			companiaSocio="999999";
		if (UString.estaVacio(periodo))
			periodo="999999";
		if (UString.estaVacio(version))
			version="999999";
		
		msgRetorno = aplicacionCodigo + "_" + reporteCodigo;
		msgRetorno = msgRetorno + "_" + companiaSocio;
		msgRetorno = msgRetorno + "_" + periodo;
		msgRetorno = msgRetorno + "_" + version;
		
		return msgRetorno;
	}
	
	public ReporteParametro() {};
	public ReporteParametro(String aplicacionCodigo,String reporteCodigo,String companiaSocio,String periodo,String version){
		this.aplicacionCodigo=aplicacionCodigo;
		this.reporteCodigo=reporteCodigo;
		
		this.companiaSocio=companiaSocio;
		this.periodo=periodo;
		this.version=version;
	}
	public ReporteParametro(String aplicacionCodigo,String reporteCodigo,String companiaSocio,String periodo){
		this.aplicacionCodigo=aplicacionCodigo;
		this.reporteCodigo=reporteCodigo;
		
		this.companiaSocio=companiaSocio;
		this.periodo=periodo;
	}
	public ReporteParametro(String aplicacionCodigo,String reporteCodigo,String companiaSocio){
		this.aplicacionCodigo=aplicacionCodigo;
		this.reporteCodigo=reporteCodigo;		
		this.companiaSocio=companiaSocio;
	}
	public ReporteParametro(String aplicacionCodigo,String reporteCodigo){
		this.aplicacionCodigo=aplicacionCodigo;
		this.reporteCodigo=reporteCodigo;
	}
	
	public String getCompaniaSocio() {
		return companiaSocio;
	}

	public void setCompaniaSocio(String companiaSocio) {
		this.companiaSocio = companiaSocio;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAplicacionCodigo() {
		return aplicacionCodigo;
	}

	public void setAplicacionCodigo(String aplicacionCodigo) {
		this.aplicacionCodigo = aplicacionCodigo;
	}

	public String getReporteCodigo() {
		return reporteCodigo;
	}

	public void setReporteCodigo(String reporteCodigo) {
		this.reporteCodigo = reporteCodigo;
	}

	public Map getParametros() {
		if (parametros==null)
			parametros=new HashMap();
		return parametros;
	}

	public void setParametros(Map parametros) {
		this.parametros = parametros;
	}
}
