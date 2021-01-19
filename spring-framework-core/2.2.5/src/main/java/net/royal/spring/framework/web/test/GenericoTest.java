package net.royal.spring.framework.web.test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import net.royal.spring.framework.core.UFile;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.core.dominio.UsuarioSeguridad;
import net.royal.spring.framework.util.UPropiedades;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.boot.ConstanteBoot;
import net.royal.spring.framework.web.multitenancy.ConstanteMultitenancy;
import net.royal.spring.framework.web.rest.SpringToken;

public class GenericoTest {
	private static Logger logger = LogManager.getLogger(GenericoTest.class);
	
	public static String apilogin;
	public static String api;
	private static String server;
	public static String nombreServicio;
	private static String recursoRuta;
	private static Properties prop;
	
	public static UsuarioSeguridad usuarioSeguridad;
	public static UsuarioActual usuarioActual;
	public static String idSid = "AAEZ";
	public static String idUsuario = "001";
	public static String idClave = "123";
	public static String idAplicacion = "BP";
	public static SpringToken springToken=null;
	
	public GenericoTest() throws Exception{
		String sRuta = System.getProperty("user.dir");
		String sRuta2 = UFile.rutaFisicaWebApp();
				
		recursoRuta = sRuta2 + File.separator + ConstanteBoot.CARPETA_PROPERTIES;		
		System.out.println(recursoRuta);
		prop = UPropiedades.getInstance().abrir(recursoRuta,ConstanteBoot.PROPERTIES_GLOBAL);		
		System.out.println(prop);
		
		if (prop!=null){
			apilogin = prop.getProperty("proxy.seguridad.autorizacion") + "/spring/seguridad/autorizacion/login";
		}
	}
	
	public GenericoTest(String nombreServicio) throws Exception{
		recursoRuta = UFile.rutaFisicaWebServer() + File.separator + ConstanteBoot.CARPETA_PROPERTIES;		
		System.out.println(recursoRuta);
		logger.debug(recursoRuta);
		prop = UPropiedades.getInstance().abrir(recursoRuta,ConstanteBoot.PROPERTIES_GLOBAL);		
		System.out.println(prop);
		logger.debug(prop);
		
		if (prop!=null){
			apilogin = prop.getProperty("proxy.seguridad.autorizacion") + "/spring/seguridad/autorizacion/login";
		}
		this.nombreServicio = nombreServicio;
		logger.debug(apilogin);
		server = prop.getProperty("port." + nombreServicio);
		server = "http://localhost:" + server;
		logger.debug(server);
	}
	
	
	public String getServer(){
		if (prop!=null){
			server = prop.getProperty("port." + nombreServicio);
			server = "http://localhost:" + server;			
			return server;	
		}else{
			return "http://localhost:8070";	
		}		
	}
	public HttpHeaders getHeaders(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		if (springToken!=null){
			if ( !UString.esNuloVacio(springToken.getToken())) {
				headers.add(ConstanteMultitenancy.TOKEN, springToken.getToken());
			}
				
		}
		return headers;
	}
	public UsuarioActual crearUsuarioActual() {
		return null;
	}
	public UsuarioActual crearUsuarioSeguridad() {
		UsuarioActual seg=new UsuarioActual();
		if (prop!=null){
			seg.setClienteCodigo(prop.getProperty("test.usuario.sid"));
			seg.setTokenCliente(prop.getProperty("test.usuario.token"));			
			seg.setUsuarioLogin(prop.getProperty("test.usuario.login"));
			seg.setUsuarioClave(prop.getProperty("test.usuario.clave"));			
			seg.setAplicacionCodigo(prop.getProperty("test.usuario.aplicacionid"));
			seg.setCompaniaSocioCodigo(prop.getProperty("test.usuario.companiaid"));
			//seg.setSucursalId(prop.getProperty("test.usuario.sucursalid"));
			//seg.setCajaId(prop.getProperty("test.usuario.cajaid"));			
		}
		return seg;
	}
	
	public ResponseEntity<String> apiEliminarPruebas() throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		URI uri = new URI(this.getServer() + api + "/eliminarpruebas");
		HttpEntity request = new HttpEntity(null, this.getHeaders());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		return result;
	}
	
	public ResponseEntity<SpringToken> apiLogin(UsuarioSeguridad usuLocal) throws URISyntaxException{
		RestTemplate restTemplate = new RestTemplate();
		if (usuLocal==null)
			usuLocal = this.crearUsuarioSeguridad();		
		HttpEntity<UsuarioSeguridad> req = new HttpEntity<UsuarioSeguridad>(usuLocal, this.getHeaders());
		ResponseEntity<SpringToken> resLogin = restTemplate.exchange(apilogin, HttpMethod.POST, req, SpringToken.class);
		springToken = resLogin.getBody();
		return resLogin;
	}
}
