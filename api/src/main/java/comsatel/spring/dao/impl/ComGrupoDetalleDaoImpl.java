package comsatel.spring.dao.impl;

import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoDetalle;
import comsatel.spring.dominio.ComGrupoDetallePk;
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
public class ComGrupoDetalleDaoImpl extends GenericoDaoImpl <ComGrupoDetalle, ComGrupoDetallePk>  {


	private static final long serialVersionUID = 1L;

	public ComGrupoDetalleDaoImpl() {
		super("comgrupodetalle");
	}

	@Resource(name = "sessionFactory")
	public void asignarSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

	public ComGrupoDetalle obtenerPorId(Integer id) {
		return obtenerPorId(new ComGrupoDetallePk(id));
	}

	public ComGrupoDetalle coreInsertar(ComGrupoDetalle bean) {
		this.registrar(bean);
		return bean;
	}

	public ComGrupoDetalle coreInsertar(UsuarioActual usuarioActual, ComGrupoDetalle bean) {
		bean.getPk().setId(generarSecuencia());
		this.registrar(bean);
		return bean;
	}

	public ComGrupoDetalle coreActualizar(UsuarioActual usuarioActual, ComGrupoDetalle bean) {
		this.actualizar(bean);
		return bean;
	}

	public ComGrupoDetalle coreActualizar(ComGrupoDetalle bean) {
		this.actualizar(bean);
		return bean;
	}

	public Integer generarSecuencia() {
		Criteria c = this.getCriteria()
				.setProjection(Projections.projectionList().add(Projections.max("pk.id")));
		return this.incrementarInteger(c);
	}
	
	@SuppressWarnings("unchecked")
	public List<ComGrupoDetalle> obtenerDetalle(Integer id) {
		Criteria c = this.getCriteria();
		c.add(Restrictions.eq("idgrupo", id));
		return c.list();
	}

	
	@Transactional
	public void coreEliminar(ComGrupoDetallePk bean) {
		ComGrupoDetalle beanCompleto = obtenerPorId(bean.getId());
		this.eliminar(beanCompleto);
	}
	
	
}
