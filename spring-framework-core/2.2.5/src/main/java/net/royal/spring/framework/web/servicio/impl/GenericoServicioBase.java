package net.royal.spring.framework.web.servicio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.ConstraintViolation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.spring.framework.util.UString;

public class GenericoServicioBase {
	private static Logger logger = LogManager.getLogger(GenericoServicioBase.class);

	@Autowired
	public ApplicationContext appContext;

	@Autowired
	private MessageSource messageSource;

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
