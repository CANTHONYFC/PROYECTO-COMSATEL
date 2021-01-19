package comsatel.spring.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoDetalle;
import comsatel.spring.dominio.ComGrupoDetallePk;
import comsatel.spring.dominio.ComGrupoPk;
import comsatel.spring.filtros.FiltroPaginacion;
import comsatel.spring.servicio.impl.ComGrupoDetalleServicioImpl;
import comsatel.spring.servicio.impl.ComsatelGruposTareasServicioImpl;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.web.rest.GenericoRest;



@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@RequestMapping("/comsateldetallerest")
@CrossOrigin(origins = "*")
public class ComGrupoDetalleRest extends GenericoRest {

	private static Logger logger = LogManager.getLogger(ComGrupoDetalleRest.class);

	@Autowired
	private ComGrupoDetalleServicioImpl servicio;

	
	@Transactional
	@PostMapping(value = "/obtenerDetalle", produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<ComGrupoDetalle> obtenerDetalle(@RequestBody ComGrupo data) {
		logger.debug("comsateldetallerest.obtenerDetalle");
		return servicio.obtenerDetalle(data.getPk().getId());
	}
	
	
	@Transactional
	@PostMapping(value = "/registrar",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupoDetalle> registrar(@RequestBody ComGrupoDetalle bean) throws Exception {
		logger.debug("comsateldetallerest.registrar");
		UsuarioActual  usu = this.getUsuarioActual();
		if (usu==null) {
			logger.debug("El usuario esta nulo");
			usu=new UsuarioActual();
			usu.setUsuarioLogin("SINUSUARIO");
		}
		bean =  servicio.coreInsertar(usu,bean);
		return new ResponseEntity<ComGrupoDetalle>(bean, HttpStatus.OK);
	}

	@Transactional
	@PutMapping(value = "/actualizar",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupoDetalle> actualizar(@RequestBody ComGrupoDetalle bean) throws Exception {
		logger.debug("comsateldetallerest.actualizar");
		UsuarioActual  usu = this.getUsuarioActual();
		if (usu==null) {
			logger.debug("El usuario esta nulo");
			usu=new UsuarioActual();
			usu.setUsuarioLogin("SINUSUARIO");
		}
		bean = servicio.coreActualizar(usu,bean);
		return new ResponseEntity<ComGrupoDetalle>(bean, HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupoDetallePk> eliminar(@RequestBody ComGrupoDetallePk pk)
			throws Exception {
		servicio.coreEliminar(this.getUsuarioActual(), pk);
		return new ResponseEntity<ComGrupoDetallePk>(pk, HttpStatus.OK);
	}
	
	
}
