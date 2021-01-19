package net.royal.spring.framework.workflow.dominio;

import java.math.BigDecimal;
import java.util.List;

public class WorkFlowTransaccion {
	private String codigoproceso;
	private String companiasocio;
	private Integer empleadosolicitante;

	private String area;
	private String centrocosto;
	private String sucursal;
	private String proyecto;

	private String valoradicional;

	private String documentotipo;
	private String documentodescripcion;
	private String documentonumero;
	private String documentoreferencia;

	private BigDecimal monto;

	private String moneda;

	private BigDecimal valornumerico1;
	private BigDecimal valornumerico2;
	private BigDecimal valornumerico3;
	private BigDecimal valornumerico4;
	private BigDecimal valornumerico5;

	private String valortexto1;
	private String valortexto2;
	private String valortexto3;
	private String valortexto4;
	private String valortexto5;

	private String ultimousuario;

	private List<WorkFlowAdjunto> adjuntos;

	public String getCodigoproceso() {
		return codigoproceso;
	}

	public void setCodigoproceso(String codigoproceso) {
		this.codigoproceso = codigoproceso;
	}

	public String getCompaniasocio() {
		return companiasocio;
	}

	public void setCompaniasocio(String companiasocio) {
		this.companiasocio = companiasocio;
	}

	public Integer getEmpleadosolicitante() {
		return empleadosolicitante;
	}

	public void setEmpleadosolicitante(Integer empleadosolicitante) {
		this.empleadosolicitante = empleadosolicitante;
	}

	public String getUltimousuario() {
		return ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCentrocosto() {
		return centrocosto;
	}

	public void setCentrocosto(String centrocosto) {
		this.centrocosto = centrocosto;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public BigDecimal getValornumerico1() {
		return valornumerico1;
	}

	public void setValornumerico1(BigDecimal valornumerico1) {
		this.valornumerico1 = valornumerico1;
	}

	public String getValoradicional() {
		return valoradicional;
	}

	public void setValoradicional(String valoradicional) {
		this.valoradicional = valoradicional;
	}

	public List<WorkFlowAdjunto> getAdjuntos() {
		return adjuntos;
	}

	public void setAdjuntos(List<WorkFlowAdjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}

	public BigDecimal getValornumerico2() {
		return valornumerico2;
	}

	public void setValornumerico2(BigDecimal valornumerico2) {
		this.valornumerico2 = valornumerico2;
	}

	public BigDecimal getValornumerico3() {
		return valornumerico3;
	}

	public void setValornumerico3(BigDecimal valornumerico3) {
		this.valornumerico3 = valornumerico3;
	}

	public BigDecimal getValornumerico4() {
		return valornumerico4;
	}

	public void setValornumerico4(BigDecimal valornumerico4) {
		this.valornumerico4 = valornumerico4;
	}

	public BigDecimal getValornumerico5() {
		return valornumerico5;
	}

	public void setValornumerico5(BigDecimal valornumerico5) {
		this.valornumerico5 = valornumerico5;
	}

	public String getValortexto1() {
		return valortexto1;
	}

	public void setValortexto1(String valortexto1) {
		this.valortexto1 = valortexto1;
	}

	public String getValortexto2() {
		return valortexto2;
	}

	public void setValortexto2(String valortexto2) {
		this.valortexto2 = valortexto2;
	}

	public String getValortexto3() {
		return valortexto3;
	}

	public void setValortexto3(String valortexto3) {
		this.valortexto3 = valortexto3;
	}

	public String getValortexto4() {
		return valortexto4;
	}

	public void setValortexto4(String valortexto4) {
		this.valortexto4 = valortexto4;
	}

	public String getValortexto5() {
		return valortexto5;
	}

	public void setValortexto5(String valortexto5) {
		this.valortexto5 = valortexto5;
	}

	public String getDocumentotipo() {
		return documentotipo;
	}

	public void setDocumentotipo(String documentotipo) {
		this.documentotipo = documentotipo;
	}

	public String getDocumentodescripcion() {
		return documentodescripcion;
	}

	public void setDocumentodescripcion(String documentodescripcion) {
		this.documentodescripcion = documentodescripcion;
	}

	public String getDocumentonumero() {
		return documentonumero;
	}

	public void setDocumentonumero(String documentonumero) {
		this.documentonumero = documentonumero;
	}

	public String getDocumentoreferencia() {
		return documentoreferencia;
	}

	public void setDocumentoreferencia(String documentoreferencia) {
		this.documentoreferencia = documentoreferencia;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

}
