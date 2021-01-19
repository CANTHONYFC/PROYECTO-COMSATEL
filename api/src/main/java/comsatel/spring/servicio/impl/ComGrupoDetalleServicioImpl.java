package comsatel.spring.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comsatel.spring.dao.impl.ComGrupoDetalleDaoImpl;
import comsatel.spring.dao.impl.ComsatelGruposTareasDaoImpl;
import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoDetalle;
import comsatel.spring.dominio.ComGrupoDetallePk;
import comsatel.spring.dominio.ComGrupoPk;
import comsatel.spring.filtros.FiltroPaginacion;
import net.royal.spring.framework.core.UException;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.UsuarioActual;

@SuppressWarnings({"unchecked", "rawtypes"})
@Service(value = "BeanServicioComGrupoDetalle")
public class ComGrupoDetalleServicioImpl {
	public static String SPRING_NOMBRE = "BeanServicioComGrupoDetalle";
	@Autowired
	private ComGrupoDetalleDaoImpl comGrupoDetalleDaoImpl;
	 
	
	@Transactional
	public List<ComGrupoDetalle> obtenerDetalle(Integer id) {
		return comGrupoDetalleDaoImpl.obtenerDetalle(id);
	}

	@Transactional
	public ComGrupoDetalle coreInsertar(UsuarioActual usuarioActual,ComGrupoDetalle ComGrupo) throws UException {
	
		return comGrupoDetalleDaoImpl.coreInsertar(usuarioActual,ComGrupo);
	}

	@Transactional
	public ComGrupoDetalle coreActualizar(UsuarioActual usuarioActual, ComGrupoDetalle comGrupo) throws UException {
	    comGrupo = comGrupoDetalleDaoImpl.coreActualizar(comGrupo);
		return comGrupo;
	}

	

	public void coreEliminar(UsuarioActual usuarioActual, ComGrupoDetallePk pk) throws UException {
		comGrupoDetalleDaoImpl.coreEliminar(pk);
	}
	
	
	
}
