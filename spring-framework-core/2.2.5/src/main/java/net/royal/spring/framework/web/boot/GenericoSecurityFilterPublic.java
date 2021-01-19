package net.royal.spring.framework.web.boot;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.royal.spring.framework.core.UFile;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.util.UPropiedades;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.multitenancy.ConstanteMultitenancy;
import net.royal.spring.framework.web.rest.HeaderMapRequestWrapper;
import net.royal.spring.framework.web.rest.SpringToken;


public class GenericoSecurityFilterPublic implements Filter{
	private static Logger logger = LogManager.getLogger(GenericoSecurityFilterPublic.class);
	private String securityServer;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		UUID uuid = UUID.randomUUID();
        String uuids = uuid.toString();
		//logger.debug("GenericoSecurityFilterPublic.doFilter:"+uuids);
		UsuarioActual usuarioActual = null;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (httpRequest.getMethod().equals("OPTIONS")) {
			chain.doFilter(request, response);
			return;
		}

		HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(httpRequest);
		
		// obtener token
		String usuarioSeguro = httpRequest.getHeader(ConstanteMultitenancy.USUARIO_SEGURO);
		String token = httpRequest.getHeader(ConstanteMultitenancy.TOKEN); 
		token = UString.obtenerSinNulo(token).replace("Bearer ", "");
		SpringToken springToken = new SpringToken(token);

		if (!UString.estaVacio(springToken.getToken())) {
			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.set(ConstanteMultitenancy.TOKEN, springToken.getToken());
				headers.set(ConstanteMultitenancy.USUARIO_SEGURO, usuarioSeguro);
				RestTemplate restTemplate = new RestTemplate();

				HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

				ResponseEntity<UsuarioActual> respEntity = restTemplate.exchange(securityServer, HttpMethod.GET, entity,UsuarioActual.class);

				usuarioActual = respEntity.getBody();
			} catch (Exception e) {
				
			}			
		}

		if (usuarioActual!=null) {
			ObjectMapper mapper = new ObjectMapper();
			requestWrapper.addHeader(ConstanteMultitenancy.USUARIO_ACTUAL, mapper.writeValueAsString(usuarioActual));	
		}
		requestWrapper.addHeader(ConstanteMultitenancy.USUARIO_SEGURO, usuarioSeguro);
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String recursoRuta = UFile.rutaFisicaWebServer() + File.separator + ConstanteBoot.CARPETA_PROPERTIES;		
		Properties recursoPropiedad;
		try {
			recursoPropiedad = recursoPropiedad = UPropiedades.getInstance().abrir(recursoRuta,ConstanteBoot.PROPERTIES_GLOBAL);
			securityServer = recursoPropiedad.getProperty("securityServer");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
