package comsatel.spring.servicio.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comsatel.spring.dao.impl.ComGrupoDetalleDaoImpl;
import comsatel.spring.dao.impl.ComsatelGruposTareasDaoImpl;
import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoDetalle;
import comsatel.spring.dominio.ComGrupoPk;
import comsatel.spring.filtros.FiltroPaginacion;
import net.royal.spring.framework.core.UException;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.web.servicio.impl.GenericoServicioImpl;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service(value = "BeanServicioComsatelGruposTareas")
public class ComsatelGruposTareasServicioImpl extends GenericoServicioImpl {
	public static String SPRING_NOMBRE = "BeanServicioComsatelGruposTareas";

	@Autowired
	private ComsatelGruposTareasDaoImpl comsatelGruposTareasDao;


	@Autowired
	private ComGrupoDetalleDaoImpl comGrupoDetalleDaoImpl;
	 
	public ParametroPaginacionGenerico listar(FiltroPaginacion filtro) {
		return comsatelGruposTareasDao.listar(filtro);
	}
	
	@Transactional
	public ComGrupo coreInsertar(UsuarioActual usuarioActual,ComGrupo ComGrupo) throws UException {
	
		return comsatelGruposTareasDao.coreInsertar(usuarioActual,ComGrupo);
	}

	@Transactional
	public ComGrupo coreActualizar(UsuarioActual usuarioActual, ComGrupo comGrupo) throws UException {
	    comGrupo = comsatelGruposTareasDao.coreActualizar(comGrupo);
		return comGrupo;
	}

	

	public void coreEliminar(UsuarioActual usuarioActual, ComGrupoPk pk) throws UException {
			List<ComGrupoDetalle> listadetalle= comGrupoDetalleDaoImpl.obtenerDetalle(pk.getId());
			for (ComGrupoDetalle beandetalle : listadetalle) {
				comGrupoDetalleDaoImpl.coreEliminar(beandetalle.getPk());
			}
		comsatelGruposTareasDao.coreEliminar(pk);
		System.out.println("ELIMINACION MASIVA OK!");
		
	}
	
	
	
	
	
	
}
