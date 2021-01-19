package net.royal.spring.framework.web.rest;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import net.royal.spring.framework.core.UException;
import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.multitenancy.ConstanteMultitenancy;
import net.royal.spring.framework.web.rest.constante.ConstanteFiltroSeguridad;

public class GenericoRest {
	private static Logger logger = LogManager.getLogger(GenericoRest.class);
	public static final String CONTENT_TYPE_APPLICATION_PDF_VALUE = "application/pdf";
	public static final String HTTP_HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_DISPOSITION_INLINE_FORMAT = "inline; filename=\"%s.pdf\"";
	public static final String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MessageSource messageSource;

	public UsuarioActual getUsuarioActualSeguridad() {
		ObjectMapper mapper = new ObjectMapper();
		String ua = request.getHeader(ConstanteFiltroSeguridad.HEADER_USUARIO_ACTUAL);
		try {
			if (UString.esNuloVacio(ua)) {
				String jwtkey = request.getHeader(ConstanteMultitenancy.TOKEN);
				
				jwtkey = UString.obtenerSinNulo(jwtkey).replace("Bearer ", "");
				
				Claims claims = Jwts.parser().setSigningKey(ConstanteFiltroSeguridad.TOKEN_JWTKEY).parseClaimsJws(jwtkey).getBody();
				ObjectMapper mapper2 = new ObjectMapper();
				UsuarioActual usu = mapper2.readValue(claims.getSubject(), UsuarioActual.class);
				
				/*
				jwtToken = Jwts.builder().setSubject(mapper.writeValueAsString(usuarioValidado)).claim("roles", "user")
						.setIssuedAt(desde).signWith(SignatureAlgorithm.HS256, ConstanteFiltroSeguridad.TOKEN_JWTKEY)
						.setExpiration(hastaLargo).compact();
				*/
				if (usu!=null)
					return usu;				
				System.err.println("HEADER_USUARIO_ACTUAL es nulo, se devuelve null");
				return null;
			}else {
				UsuarioActual usu = mapper.readValue(ua, UsuarioActual.class);
				return usu;	
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public UsuarioActual getUsuarioActual() {
		ObjectMapper mapper = new ObjectMapper();
		String ua = request.getHeader(ConstanteFiltroSeguridad.HEADER_USUARIO_ACTUAL);
		try {
			if (UString.esNuloVacio(ua)) {
				String jwtkey = request.getHeader(ConstanteMultitenancy.TOKEN);
				
				jwtkey = UString.obtenerSinNulo(jwtkey).replace("Bearer ", "");
				
				Claims claims = Jwts.parser().setSigningKey(ConstanteFiltroSeguridad.TOKEN_JWTKEY).parseClaimsJws(jwtkey).getBody();
				ObjectMapper mapper2 = new ObjectMapper();
				UsuarioActual usu = mapper2.readValue(claims.getSubject(), UsuarioActual.class);
				if (usu!=null)
					return usu;				
				System.err.println("HEADER_USUARIO_ACTUAL es nulo, se devuelve null");
				return null;
			}else{
				UsuarioActual usu = mapper.readValue(ua, UsuarioActual.class);
				return usu;	
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void enviarReportePdf(byte[] contenido, HttpServletResponse response) throws IOException {
		InputStream inputStream;

		response.setContentType(CONTENT_TYPE_APPLICATION_PDF_VALUE);
		response.setHeader(HTTP_HEADER_CONTENT_DISPOSITION,
				String.format(CONTENT_DISPOSITION_INLINE_FORMAT, UUID.randomUUID()));
		response.setContentLength(contenido.length);

		inputStream = new BufferedInputStream(new ByteArrayInputStream(contenido));
		StreamUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();
	}

	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(UsuarioActual.class, new UsuarioActualEditor());
	 * }
	 */

	@ExceptionHandler({ UException.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		List<MensajeUsuario> apiError = ((UException) ex).getErrors();
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.CONFLICT);
	}	
	public String getMessage(String msgCode) {
		Locale locale = LocaleContextHolder.getLocale();
		return getMessageBase(msgCode, null, null, locale);
	}
	public String getMessage(String msgCode, String defaultMsg) {
		Locale locale = LocaleContextHolder.getLocale();
		return getMessageBase(msgCode, null, defaultMsg, locale);
	}
	private String getMessageBase(String msgCode, Object[] params, String defaultMsg, Locale locale) {
		try {
			if (locale == null)
				locale = LocaleContextHolder.getLocale();
			//messageSource.
			defaultMsg = UString.esNuloVacio(defaultMsg) ? msgCode : defaultMsg;
			String msg = messageSource.getMessage(msgCode, params, defaultMsg, locale);
			return UString.esNuloVacio(msg) ? msgCode : msg;
		} catch (Exception e) {
			logger.error(msgCode);
		}
		return msgCode;
	}
	public MensajeUsuario getMsjUsuarioError(String msgCode) {
		String msg = getMessage(msgCode);
		MensajeUsuario msj = new MensajeUsuario(tipo_mensaje.ERROR, msg);
		return msj;
	}
	public MensajeUsuario getMsjUsuarioError(ConstraintViolation cons) {
		String msg = cons.getRootBeanClass().getSimpleName();
		msg = msg + "." + cons.getPropertyPath().toString();
		msg = msg + cons.getMessageTemplate().replace("{javax.validation", "").replace(".message}", "");
		msg = getMessage(msg.toLowerCase());
		MensajeUsuario msj = new MensajeUsuario(tipo_mensaje.ERROR, msg);
		return msj;
	}	
	public List<MensajeUsuario> setMessageError(List<MensajeUsuario> lst,String msg) {
		if (lst==null)
			lst=new ArrayList<>();
		lst.add(new MensajeUsuario(tipo_mensaje.ERROR, msg));
		return lst;
	}
}
