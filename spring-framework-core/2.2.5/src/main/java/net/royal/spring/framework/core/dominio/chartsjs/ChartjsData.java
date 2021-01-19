package net.royal.spring.framework.core.dominio.chartsjs;

import java.math.BigDecimal;

public class ChartjsData {
	private String nombre;
	private String descripcion;
	private BigDecimal valor1;
	private BigDecimal valor2;
	
	public ChartjsData() {}
	public ChartjsData(String nombre,BigDecimal valor1) {
		this.nombre=nombre;
		this.valor1=valor1;
	}
	public ChartjsData(String nombre,BigDecimal valor1,BigDecimal valor2) {
		this.nombre=nombre;
		this.valor1=valor1;
		this.valor2=valor2;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getValor1() {
		return valor1;
	}
	public void setValor1(BigDecimal valor1) {
		this.valor1 = valor1;
	}
	public BigDecimal getValor2() {
		return valor2;
	}
	public void setValor2(BigDecimal valor2) {
		this.valor2 = valor2;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}		
}
