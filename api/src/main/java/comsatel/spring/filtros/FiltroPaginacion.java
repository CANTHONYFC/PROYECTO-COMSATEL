package comsatel.spring.filtros;

import java.math.BigDecimal;

import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;

public class FiltroPaginacion {
	public ParametroPaginacionGenerico paginacion;
	private BigDecimal ROWNUM_;
	private Integer tipobusqueda;
	
	
	public Integer getTipobusqueda() {
		return tipobusqueda;
	}

	public void setTipobusqueda(Integer tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}

	public BigDecimal getROWNUM_() {
		return ROWNUM_;
	}

	public void setROWNUM_(BigDecimal rOWNUM_) {
		ROWNUM_ = rOWNUM_;
	}

	public ParametroPaginacionGenerico getPaginacion() {
		return paginacion;
	}

	public void setPaginacion(ParametroPaginacionGenerico paginacion) {
		this.paginacion = paginacion;
	}
	
	
}
