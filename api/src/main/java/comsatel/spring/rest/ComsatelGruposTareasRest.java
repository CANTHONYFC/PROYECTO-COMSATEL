package comsatel.spring.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comsatel.spring.dao.impl.ComGrupoDetalleDaoImpl;
import comsatel.spring.dominio.ComGrupo;
import comsatel.spring.dominio.ComGrupoDetalle;
import comsatel.spring.dominio.ComGrupoPk;
import comsatel.spring.filtros.FiltroPaginacion;
import comsatel.spring.servicio.impl.ComsatelGruposTareasServicioImpl;
import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.web.rest.GenericoRest;

@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@RequestMapping("/comsatelrest")
@CrossOrigin(origins = "*")
public class ComsatelGruposTareasRest  extends GenericoRest {

	private static Logger logger = LogManager.getLogger(ComsatelGruposTareasRest.class);

	@Autowired
	private ComsatelGruposTareasServicioImpl servicio;
	
	@PostMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ParametroPaginacionGenerico listar(@RequestBody FiltroPaginacion filtro) {
		logger.debug("comsatelrest.listar");
		return servicio.listar(filtro);
	}
	
	
	@Transactional
	@PostMapping(value = "/registrar",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupo> registrar(@RequestBody ComGrupo bean) throws Exception {
		logger.debug("comsatelrest.registrar");
		UsuarioActual  usu = this.getUsuarioActual();
		if (usu==null) {
			logger.debug("El usuario esta nulo");
			usu=new UsuarioActual();
			usu.setUsuarioLogin("SINUSUARIO");
		}
		bean =  servicio.coreInsertar(usu,bean);
		return new ResponseEntity<ComGrupo>(bean, HttpStatus.OK);
	}

	@Transactional
	@PutMapping(value = "/actualizar",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupo> actualizar(@RequestBody ComGrupo bean) throws Exception {
		logger.debug("comsatelrest.actualizar");
		UsuarioActual  usu = this.getUsuarioActual();
		if (usu==null) {
			logger.debug("El usuario esta nulo");
			usu=new UsuarioActual();
			usu.setUsuarioLogin("SINUSUARIO");
		}
		bean = servicio.coreActualizar(usu,bean);
		return new ResponseEntity<ComGrupo>(bean, HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComGrupoPk> eliminar(@RequestBody ComGrupoPk pk)
			throws Exception {
	
		servicio.coreEliminar(this.getUsuarioActual(), pk);
		return new ResponseEntity<ComGrupoPk>(pk, HttpStatus.OK);
	}
	
	


	
}
