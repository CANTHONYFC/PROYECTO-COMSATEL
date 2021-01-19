package comsatel.spring.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoPk;
import comsatel.spring.dominio.dto.DtolistarGrupoDetalle;
import comsatel.spring.filtros.FiltroPaginacion;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.ParametroPersistenciaGenerico;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.util.UInteger;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.dao.impl.GenericoDaoImpl;

@SuppressWarnings({"unchecked", "rawtypes"})
@Repository
public class ComsatelGruposTareasDaoImpl extends GenericoDaoImpl<ComGrupo, ComGrupoPk> {


	private static final long serialVersionUID = 1L;

	public ComsatelGruposTareasDaoImpl() {
		super("comgrupo");
	}

	@Resource(name = "sessionFactory")
	public void asignarSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public ComGrupo obtenerPorId(Integer id) {
		return obtenerPorId(new ComGrupoPk(id));
	}

	public ComGrupo coreInsertar(ComGrupo bean) {
		bean.getPk().setId(generarSecuencia());
		this.registrar(bean);
		return bean;
	}

	public ComGrupo coreInsertar(UsuarioActual usuarioActual, ComGrupo bean) {
		bean.getPk().setId(generarSecuencia());
		this.registrar(bean);
		return bean;
	}

	public ComGrupo coreActualizar(UsuarioActual usuarioActual, ComGrupo bean) {
		this.actualizar(bean);
		return bean;
	}

	public ComGrupo coreActualizar(ComGrupo bean) {
		this.actualizar(bean);
		return bean;
	}

	public Integer generarSecuencia() {
		Criteria c = this.getCriteria()
				.setProjection(Projections.projectionList().add(Projections.max("pk.id")));
		return this.incrementarInteger(c);
	}
	
	@Transactional
	public void coreEliminar(ComGrupoPk bean) {
		ComGrupo beanCompleto = obtenerPorId(bean.getId());
		this.eliminar(beanCompleto);
	}
	
	@Transactional(readOnly = true)
	public ParametroPaginacionGenerico listar(FiltroPaginacion filtro) {
		List<ParametroPersistenciaGenerico> parametros = new ArrayList<ParametroPersistenciaGenerico>();
		

//		parametros.add(new ParametroPersistenciaGenerico("p_codigo", String.class, filtro.getCodigo()));
//	
if(filtro.getTipobusqueda()==0) {
	logger.debug("Lista de Pendientes");

	Integer registros = contar("comgrupo.contarpendientes", parametros);

	List <?> datos = listarPorQuery(DtolistarGrupoDetalle.class, "comgrupo.listarpendientes",
			parametros);
	logger.debug("Listado --OK!");
	filtro.paginacion.setPaginacionRegistrosEncontrados(registros.intValue());
	filtro.paginacion.setPaginacionListaResultado(datos);
}else {
	logger.debug("Lista de Completados");

	Integer registros = contar("comgrupo.contarcompletados", parametros);

	List <?> datos = listarPorQuery(DtolistarGrupoDetalle.class, "comgrupo.listarcompletados",
			parametros);
	logger.debug("Listado --OK!");
	filtro.paginacion.setPaginacionRegistrosEncontrados(registros.intValue());
	filtro.paginacion.setPaginacionListaResultado(datos);
	
}

		return filtro.paginacion;
	}

}
