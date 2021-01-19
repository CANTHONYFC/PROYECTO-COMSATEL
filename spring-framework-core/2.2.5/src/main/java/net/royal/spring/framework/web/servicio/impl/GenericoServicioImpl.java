package net.royal.spring.framework.web.servicio.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.royal.spring.framework.adjunto.dominio.AdjuntoClonar;
import net.royal.spring.framework.adjunto.dominio.AdjuntoTransaccion;
import net.royal.spring.framework.core.UFile;
import net.royal.spring.framework.core.UList;
import net.royal.spring.framework.core.dominio.DominioArchivo;
import net.royal.spring.framework.core.dominio.DominioExportar;
import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.TipoCambioTransaccion;
import net.royal.spring.framework.core.dominio.UsuarioActual;
import net.royal.spring.framework.core.dominio.dto.DtoAgroPersona;
import net.royal.spring.framework.correo.dominio.Email;
import net.royal.spring.framework.correo.dominio.EmailResultado;
import net.royal.spring.framework.logistica.dominio.WhDocumentoArchivoTransaccion;
import net.royal.spring.framework.pdf.ImprimirPdf;
import net.royal.spring.framework.reporte.dominio.ReporteParametro;
import net.royal.spring.framework.reporte.dominio.ReporteResultado;
import net.royal.spring.framework.util.UPropiedades;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.boot.ConstanteBoot;
import net.royal.spring.framework.web.multitenancy.ConstanteMultitenancy;
import net.royal.spring.framework.web.rest.SpringToken;
import net.royal.spring.framework.web.rest.constante.ConstanteFiltroSeguridad;
import net.royal.spring.framework.web.servicio.GenericoServicio;
import net.royal.spring.framework.workflow.dominio.WorkFlowResultado;
import net.royal.spring.framework.workflow.dominio.WorkFlowTransaccion;

public class GenericoServicioImpl extends GenericoServicioBase implements GenericoServicio {

	private static Logger logger = LogManager.getLogger(GenericoServicioImpl.class);


	@Autowired
	private HttpServletRequest request;

	public enum accion_solicitada {
		NUEVO, REGISTRAR, ACTUALIZAR, ELIMINAR, INACTIVAR, EJECUTAR, BUSCAR, EDITAR, VER, SALIR, LISTAR, CONFIGURABLE,
		IMPRIMIR, OTROS
	};
	
	/** REGISTRAR PERSONA ERP: INICIO **/
	public DtoAgroPersona personaErpRegistrar(DtoAgroPersona bean) throws Exception {
		DtoAgroPersona res = new DtoAgroPersona();
		try {			
			if (apiSgaiCore == null)
				leerPropiedades();

			String uripersona = apiSgaiCore + "spring/comun/core/personamast/crearpersonaagro"; 
					
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(uripersona);
			logger.debug(uri);

			HttpEntity<DtoAgroPersona> request = new HttpEntity<DtoAgroPersona>(bean, this.getHeaders());
			ResponseEntity<DtoAgroPersona> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					DtoAgroPersona.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiSgaiCore:" + UString.obtenerSinNulo(apiSgaiCore));
			res.setTransaccionEstado(TipoCambioTransaccion.ERROR);
			res.setTransaccionMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** REGISTRAR PERSONA ERP: FIN **/

	/** TIPO DE CAMBIO: INICIO **/
	public TipoCambioTransaccion obtenerTipoCambio(TipoCambioTransaccion bean) throws Exception {
		TipoCambioTransaccion res = new TipoCambioTransaccion();
		try {
			if (apiObtenerTipoCambio == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiObtenerTipoCambio);
			logger.debug(uri);

			HttpEntity<TipoCambioTransaccion> request = new HttpEntity<TipoCambioTransaccion>(bean, this.getHeaders());
			ResponseEntity<TipoCambioTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					TipoCambioTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiObtenerTipoCambio:" + UString.obtenerSinNulo(apiObtenerTipoCambio));
			res.setEstado(TipoCambioTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** TIPO DE CAMBIO: FIN **/

	/** ADJUNTOS : INICIO **/
	public AdjuntoTransaccion eliminarAdjunto(AdjuntoTransaccion bean) throws Exception {
		AdjuntoTransaccion res = new AdjuntoTransaccion();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/eliminar");
			logger.debug(uri);

			HttpEntity<AdjuntoTransaccion> request = new HttpEntity<AdjuntoTransaccion>(bean, this.getHeaders());
			ResponseEntity<AdjuntoTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					AdjuntoTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			res.setEstado(AdjuntoTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public AdjuntoClonar clonar(AdjuntoClonar bean) throws Exception {
		AdjuntoClonar res = new AdjuntoClonar();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/clonar");
			logger.debug(uri);

			HttpEntity<AdjuntoClonar> request = new HttpEntity<AdjuntoClonar>(bean, this.getHeaders());
			ResponseEntity<AdjuntoClonar> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					AdjuntoClonar.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			res.setEstado(AdjuntoTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public List<MensajeUsuario> adjuntoValidar(AdjuntoTransaccion bean) throws Exception {
		List<MensajeUsuario> res = new ArrayList<MensajeUsuario>();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/validar");
			logger.debug(uri);

			HttpEntity<AdjuntoTransaccion> request = new HttpEntity<AdjuntoTransaccion>(bean, this.getHeaders());
			ResponseEntity<List<MensajeUsuario>> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					new ParameterizedTypeReference<List<MensajeUsuario>>() {
					});
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			e.printStackTrace();
		}
		return res;
	}

	public AdjuntoTransaccion adjuntoActualizar(AdjuntoTransaccion bean) throws Exception {
		AdjuntoTransaccion res = new AdjuntoTransaccion();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/actualizar");
			logger.debug(uri);

			HttpEntity<AdjuntoTransaccion> request = new HttpEntity<AdjuntoTransaccion>(bean, this.getHeaders());
			ResponseEntity<AdjuntoTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					AdjuntoTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			res.setEstado(AdjuntoTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public AdjuntoTransaccion adjuntoObtenerPorIdDocumento(AdjuntoTransaccion bean) throws Exception {
		AdjuntoTransaccion res = new AdjuntoTransaccion();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/obtenerporiddocumento");
			logger.debug(uri);

			HttpEntity<AdjuntoTransaccion> request = new HttpEntity<AdjuntoTransaccion>(bean, this.getHeaders());
			ResponseEntity<AdjuntoTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					AdjuntoTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			res.setEstado(AdjuntoTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public AdjuntoTransaccion adjuntoObtenerPorIdDocumentoDetalle(AdjuntoTransaccion bean) throws Exception {
		AdjuntoTransaccion res = new AdjuntoTransaccion();
		try {
			if (apiAdjuntoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiAdjuntoExterno + "/obtenerporiddocumentodetalle");
			logger.debug(uri);

			HttpEntity<AdjuntoTransaccion> request = new HttpEntity<AdjuntoTransaccion>(bean, this.getHeaders());
			ResponseEntity<AdjuntoTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					AdjuntoTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiAdjuntoExterno:" + UString.obtenerSinNulo(apiAdjuntoExterno));
			res.setEstado(AdjuntoTransaccion.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** ADJUNTOS : FIN **/

	/** DOCUMENTO : INICIO **/
	public WhDocumentoArchivoTransaccion documentosProcesar(WhDocumentoArchivoTransaccion bean) throws Exception {
		WhDocumentoArchivoTransaccion res = new WhDocumentoArchivoTransaccion();
		try {
			if (apiDocumentoExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiDocumentoExterno + "/documentosProcesar");
			logger.debug(uri);

			HttpEntity<WhDocumentoArchivoTransaccion> request = new HttpEntity<WhDocumentoArchivoTransaccion>(bean,
					this.getHeaders());
			ResponseEntity<WhDocumentoArchivoTransaccion> result = restTemplate.exchange(uri, HttpMethod.PUT, request,
					WhDocumentoArchivoTransaccion.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiDocumentoExterno:" + UString.obtenerSinNulo(apiDocumentoExterno));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** DOCUMENTO : FIN **/

	/** WORKFLOW : INICIO **/
	public WorkFlowResultado workflowRegistrar(WorkFlowTransaccion bean) throws Exception {
		WorkFlowResultado res = new WorkFlowResultado();
		try {
			if (apiWorkFlowExterno == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiWorkFlowExterno + "/registrarExterno");
			logger.debug(uri);

			HttpEntity<WorkFlowTransaccion> request = new HttpEntity<WorkFlowTransaccion>(bean, this.getHeaders());
			ResponseEntity<WorkFlowResultado> result = restTemplate.exchange(uri, HttpMethod.POST, request,
					WorkFlowResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiWorkFlowExterno:" + UString.obtenerSinNulo(apiWorkFlowExterno));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** WORKFLOW : FIN **/

	/** EXPORTAR : INICIO **/
	public DominioArchivo exportarInformacion(String formato, List lstDatos) throws Exception {
		return exportarInformacion(formato, lstDatos, null);
	}

	public DominioArchivo exportarInformacion(String formato, List lstDatos, String[] arrColumnas) throws Exception {
		DominioArchivo dto = null;
		if (lstDatos == null) {
			return null;
		}
		if (propiedades == null)
			leerPropiedades();
		logger.debug(formato);
		logger.debug(lstDatos.size());
		logger.debug("rutaTemporalFisica:" + UString.obtenerSinNulo(rutaTemporalFisica));
		UList.rutaTemporal = rutaTemporalFisica;

		if (formato.equals("XLS")) {
			//dto = UList.listToXls(lstDatos, arrColumnas);
			dto = exportarInformacion(new DominioExportar(formato,lstDatos,arrColumnas));
		}			
		if (formato.equals("PDF")) {
			//dto = UList.listToPdf(lstDatos, arrColumnas);
			dto = exportarInformacion(new DominioExportar(formato,lstDatos,arrColumnas));
		}			
		if (formato.equals("XML"))
			dto = UList.listToXml(lstDatos);		
		if (formato.equals("CSV"))
			dto = UList.listToCsv(lstDatos, arrColumnas);
		if (formato.equals("TXT"))
			dto = UList.listToTxt(lstDatos, arrColumnas);
		return dto;
	}
	
	public DominioArchivo exportarInformacion(DominioExportar exp) throws Exception {
		logger.debug("exportarInformacion(DominioExportar dtoExportar) ");		
		UsuarioActual usu = this.getUsuarioActual();
		String usua = usu.getUsuarioLogin();
		logger.debug(usua);
		//usua = "DARIO QQUECHO QUISPE";
		
		DominioArchivo dto = null;
		if (exp.getLstDatos() == null) {
			return null;
		}
		if (propiedades == null)
			leerPropiedades();
		logger.debug(exp.getFormato());
		logger.debug(exp.getLstDatos().size());
		logger.debug("rutaTemporalFisica:" + UString.obtenerSinNulo(rutaTemporalFisica));
		UList.rutaTemporal = rutaTemporalFisica;
		
		
		List<String> atributos = null;
		List<String> cabeceras = null;
		if (exp.getArrColumnas()!=null) {
			atributos = new ArrayList<>();
			String[] arrColumnas = exp.getArrColumnas();
			for (int i = 0; i <arrColumnas.length; i ++) {
				atributos.add(arrColumnas[i]);
			}	
		}
		if (exp.getArrCabeceras()!=null) {
			cabeceras = new ArrayList<>();
			String[] arrCabeceras = exp.getArrCabeceras();
			for (int i = 0; i <arrCabeceras.length; i ++) {
				cabeceras.add(arrCabeceras[i]);
			}	
		}else {
			cabeceras = atributos;
		}
		if (exp.getFormato().equals("XLS")) {
			logger.debug("exportarInformacion(DominioExportar dtoExportar):XLS");
			//dto = UList.listToXls(dtoExportar.getLstDatos(), dtoExportar.getArrColumnas());			
			dto = exportarInformacionExcel(UString.obtenerValorCadenaSinNulo(exp.getTitulo()),usua,cabeceras,atributos,exp.getLstDatos());
		}			
		if (exp.getFormato().equals("XML")) {
			dto = exportarInformacionXML(UString.obtenerValorCadenaSinNulo(exp.getTitulo()),usua,cabeceras,atributos,exp.getLstDatos());
		}			
		if (exp.getFormato().equals("PDF")) {
			logger.debug("exportarInformacion(DominioExportar dtoExportar):PDF");
			//dto = UList.listToPdf(dtoExportar.getLstDatos(), dtoExportar.getArrColumnas());			
			dto = exportarInformacionPdf(UString.obtenerValorCadenaSinNulo(exp.getTitulo()),usua,cabeceras,atributos,exp.getLstDatos(),exp.isVertical());
		}			
		if (exp.getFormato().equals("CSV"))
			dto = UList.listToCsv(exp.getLstDatos(), exp.getArrColumnas());
		if (exp.getFormato().equals("TXT"))
			dto = UList.listToTxt(exp.getLstDatos(), exp.getArrColumnas());
		return dto;
	}
	
	private DominioArchivo exportarInformacionXML(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List objetos) throws Exception {
		logger.debug("exportarInformacionXML");
		if (propiedades == null)
			leerPropiedades();
		UList.rutaTemporal = rutaTemporalFisica;
		
		if (UString.esNuloVacio(titulo))
			titulo ="Reporte";
		
		String rutaCompletaXML = UList.generarNombreAleatorio("xml");
		DominioArchivo dto = ImprimirPdf.imprimirXML(titulo, usuario, cabeceras, atributos, objetos, rutaCompletaXML);

		return dto;
	}

	public DominioArchivo exportarInformacionPdf(String titulo, String usuario, List<String> atributos, List objetos,
			boolean vertical) throws Exception {
		return exportarInformacionPdf(titulo, usuario, atributos, atributos, objetos, vertical);
	}

	public DominioArchivo exportarInformacionPdf(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List objetos) throws Exception {
		return exportarInformacionPdf(titulo, usuario, cabeceras, atributos, objetos, true);
	}

	public DominioArchivo exportarInformacionPdf(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List objetos, boolean vertical) throws Exception {
		logger.debug("exportarInformacionPdf");
		DominioArchivo dto = new DominioArchivo();
		if (propiedades == null)
			leerPropiedades();
		UList.rutaTemporal = rutaTemporalFisica;
		String rutaCompletaPdf = UList.generarNombreAleatorio("pdf");
		ImprimirPdf.imprimirPdf(titulo, usuario, cabeceras, atributos, objetos, vertical, rutaCompletaPdf,
				imagenReportes);

		dto.setRutaCompleta(rutaCompletaPdf);
		dto.setArchivoFile(new File(rutaCompletaPdf));
		dto.obtenerMimeType();
		dto.setNombre(dto.getArchivoFile().getName());

		return dto;
	}

	public DominioArchivo exportarInformacionExcel(String titulo, String usuario, List<String> cabeceras,
			List<String> atributos, List objetos) throws Exception {
		logger.debug("exportarInformacionExcel");
		if (propiedades == null)
			leerPropiedades();
		UList.rutaTemporal = rutaTemporalFisica;
		
		if (UString.esNuloVacio(titulo))
			titulo ="Hoja";
		
		String rutaCompletaPdf = UList.generarNombreAleatorio("xls");
		DominioArchivo dto = ImprimirPdf.imprimirExcel(titulo, usuario, cabeceras, atributos, objetos, rutaCompletaPdf,
				imagenReportes);

		return dto;
	}

	/** EXPORTAR : FIN **/

	/** CORREO : INICIO **/
	public EmailResultado correoEnviar(Email bean) throws Exception {
		return correoEnviar(bean, null);
	}

	public EmailResultado correoEnviar(Email bean, SpringToken token) throws Exception {
		EmailResultado res = new EmailResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiCorreoEnviar);

			HttpEntity<Email> request = new HttpEntity<Email>(bean, this.getHeaders(token));
			ResponseEntity<EmailResultado> result = restTemplate.exchange(uri, HttpMethod.POST, request,
					EmailResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiCorreoEnviar:" + UString.obtenerSinNulo(apiCorreoEnviar));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public void correoEnviarAsincrono(Email bean) throws Exception {
		correoEnviarAsincrono(bean, null);
	}

	public void correoEnviarAsincrono(Email bean, SpringToken token) throws Exception {
		EmailResultado res = new EmailResultado();
		try {
			if (propiedades == null)
				leerPropiedades();
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiCorreoEnviar);

			HttpEntity<Email> request = new HttpEntity<Email>(bean, this.getHeaders(token));
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.submit(() -> {
				ResponseEntity<EmailResultado> result = restTemplate.exchange(uri, HttpMethod.POST, request,
						EmailResultado.class);
			});
		} catch (Exception e) {
			logger.error("apiCorreoEnviar:" + UString.obtenerSinNulo(apiCorreoEnviar));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
	}

	public EmailResultado correoEnviarInseguro(Email bean) throws Exception {
		EmailResultado res = new EmailResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiCorreoEnviar);

			HttpEntity<Email> request = new HttpEntity<Email>(bean, this.getHeadersInseguro());
			ResponseEntity<EmailResultado> result = restTemplate.exchange(uri, HttpMethod.POST, request,
					EmailResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiCorreoEnviar:" + UString.obtenerSinNulo(apiCorreoEnviar));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public void correoEnviarAsincronoInseguro(Email bean) throws Exception {
		EmailResultado res = new EmailResultado();
		try {
			if (propiedades == null)
				leerPropiedades();
			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiCorreoEnviar);

			HttpEntity<Email> request = new HttpEntity<Email>(bean, this.getHeadersInseguro());
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.submit(() -> {
				ResponseEntity<EmailResultado> result = restTemplate.exchange(uri, HttpMethod.POST, request,
						EmailResultado.class);
			});
		} catch (Exception e) {
			logger.error("apiCorreoEnviar:" + UString.obtenerSinNulo(apiCorreoEnviar));
			res.setEstado(EmailResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
	}

	/** CORREO : FIN **/

	/** REPORTES : INICIO **/
	public ReporteResultado reporteEjecutar(ReporteParametro bean) throws Exception {
		ReporteResultado res = new ReporteResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiReporte + "spring/sistema/syreportemotor/ejecutar");
			HttpEntity<ReporteParametro> requestp = new HttpEntity<ReporteParametro>(bean, this.getHeaders());
			ResponseEntity<ReporteResultado> result = restTemplate.exchange(uri, HttpMethod.PUT, requestp,
					ReporteResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiReporte:" + UString.obtenerSinNulo(apiReporte));
			res.setEstado(ReporteResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public ReporteResultado reporteEjecutarCadena(ReporteParametro bean) throws Exception {
		ReporteResultado res = new ReporteResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiReporte + "spring/sistema/syreportemotor/ejecutarCadena");
			HttpEntity<ReporteParametro> requestp = new HttpEntity<ReporteParametro>(bean, this.getHeaders());
			ResponseEntity<ReporteResultado> result = restTemplate.exchange(uri, HttpMethod.PUT, requestp,
					ReporteResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiReporte:" + UString.obtenerSinNulo(apiReporte));
			res.setEstado(ReporteResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public ReporteResultado reporteEjecutarInseguro(ReporteParametro bean) throws Exception {
		ReporteResultado res = new ReporteResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiReporte + "spring/sistema/syreportemotor/ejecutar");
			HttpHeaders headerInseguro = this.getHeadersInseguro();
			HttpEntity<ReporteParametro> requestp = new HttpEntity<ReporteParametro>(bean, headerInseguro);
			ResponseEntity<ReporteResultado> result = restTemplate.exchange(uri, HttpMethod.PUT, requestp,
					ReporteResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiReporte:" + UString.obtenerSinNulo(apiReporte));
			res.setEstado(ReporteResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public ReporteResultado reporteEjecutarCadenaInseguro(ReporteParametro bean) throws Exception {
		ReporteResultado res = new ReporteResultado();
		try {
			if (propiedades == null)
				leerPropiedades();

			RestTemplate restTemplate = new RestTemplate();
			URI uri = new URI(apiReporte + "spring/sistema/syreportemotor/ejecutarCadena");
			HttpHeaders headerInseguro = this.getHeadersInseguro();
			HttpEntity<ReporteParametro> requestp = new HttpEntity<ReporteParametro>(bean, headerInseguro);
			ResponseEntity<ReporteResultado> result = restTemplate.exchange(uri, HttpMethod.PUT, requestp,
					ReporteResultado.class);
			return result.getBody();
		} catch (Exception e) {
			logger.error("apiReporte:" + UString.obtenerSinNulo(apiReporte));
			res.setEstado(ReporteResultado.ERROR);
			res.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	/** REPORTES : FIN **/

	private static Properties propiedades;
	private static String apiReporte;
	private static String imagenReportes;
	private static String apiCorreoEnviar;
	private static String rutaTemporalFisica;
	private static String apiWorkFlowExterno;
	private static String apiDocumentoExterno;
	private static String apiAdjuntoExterno;
	private static String apiObtenerTipoCambio;
	
	private static String apiSgaiCore;

	private void leerPropiedades() throws Exception {
		String rutaPropiedades = UFile.rutaFisicaWebServer() + File.separator + ConstanteBoot.CARPETA_PROPERTIES;
		logger.debug(rutaPropiedades);
		propiedades = UPropiedades.getInstance().abrir(rutaPropiedades, ConstanteBoot.PROPERTIES_GLOBAL);
		logger.debug(propiedades);
		if (propiedades != null) {
			apiSgaiCore = UString.obtenerSinNulo(propiedades.getProperty("proxy.sgai.core"));
			apiReporte = UString.obtenerSinNulo(propiedades.getProperty("proxy.sistema.reporte"));
			apiWorkFlowExterno = UString.obtenerSinNulo(propiedades.getProperty("workFlowExterno"));
			apiDocumentoExterno = UString.obtenerSinNulo(propiedades.getProperty("documentoExterno"));
			apiAdjuntoExterno = UString.obtenerSinNulo(propiedades.getProperty("adjuntoExterno"));
			apiCorreoEnviar = UString.obtenerSinNulo(propiedades.getProperty("correoEnviar"));
			rutaTemporalFisica = UString.obtenerSinNulo(propiedades.getProperty("ruta.fisica.temporal"));
			apiObtenerTipoCambio = UString.obtenerSinNulo(propiedades.getProperty("apiObtenerTipoCambio"));
			imagenReportes = UString.obtenerSinNulo(propiedades.getProperty("imagenReportes"));
		}
	}

	public HttpHeaders getHeadersInseguro() {
		HttpHeaders h = this.getHeaders();
		h.add(ConstanteMultitenancy.USUARIO_SEGURO, ConstanteMultitenancy.USUARIO_SEGURO_KEY);
		return h;
	}

	public HttpHeaders getHeaders() {
		return getHeaders(null);
	}

	public HttpHeaders getHeaders(SpringToken token) {
		HttpHeaders headers = new HttpHeaders();
		String idtoken = request.getHeader(ConstanteMultitenancy.TOKEN);
		if (token != null && UString.esNuloVacio(idtoken)) {
			if (!UString.esNuloVacio(token.getToken())) {
				idtoken = token.getToken();
			}
		}
		headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.add(ConstanteMultitenancy.TOKEN, idtoken);
		return headers;
	}
	
	public UsuarioActual getUsuarioActual() {
		ObjectMapper mapper = new ObjectMapper();
		String ua = request.getHeader(ConstanteFiltroSeguridad.HEADER_USUARIO_ACTUAL);
		try {
			if (UString.esNuloVacio(ua)) {
				System.err.println("HEADER_USUARIO_ACTUAL es nulo, se devuelve null");
				return null;
			}
			UsuarioActual usu = mapper.readValue(ua, UsuarioActual.class);
			return usu;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
