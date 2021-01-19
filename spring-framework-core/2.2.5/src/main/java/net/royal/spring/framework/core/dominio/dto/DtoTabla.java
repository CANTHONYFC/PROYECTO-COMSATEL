package net.royal.spring.framework.core.dominio.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class DtoTabla implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String estado;
	private BigDecimal ROWNUM_;
	
	private String companiaId;
	private String companiaNombre;
	
	private BigDecimal valorint1;
	private BigDecimal valorint2;
	private BigDecimal orden;
	
	public BigDecimal getValorint1() {
		return valorint1;
	}

	public void setValorint1(BigDecimal valorint1) {
		this.valorint1 = valorint1;
	}

	public BigDecimal getValorint2() {
		return valorint2;
	}

	public void setValorint2(BigDecimal valorint2) {
		this.valorint2 = valorint2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DtoTabla() {
	}

	public DtoTabla(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

	public String getCompaniaId() {
		return companiaId;
	}

	public void setCompaniaId(String companiaId) {
		this.companiaId = companiaId;
	}

	public String getCompaniaNombre() {
		return companiaNombre;
	}

	public void setCompaniaNombre(String companiaNombre) {
		this.companiaNombre = companiaNombre;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}
	
	
//
//	public static List<DtoTabla> obtenerLista(String[] listaCodigos) {
//		List<DtoTabla> lst = new ArrayList<>();
//		if (listaCodigos == null)
//			return lst;
//		for (int i=0; i<listaCodigos.length; i++){
//			lst.add(new DtoTabla(listaCodigos[i], null));
//		}
//		return lst;
//	}
}
