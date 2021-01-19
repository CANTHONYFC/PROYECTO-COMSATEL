package net.royal.spring.framework.web.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import net.royal.spring.framework.core.UValidador;
import net.royal.spring.framework.core.dominio.ConstanteDatos.SORT_ORDER;
import net.royal.spring.framework.core.dominio.ConstanteDatos.TIPO_OPERACION;
import net.royal.spring.framework.core.dominio.DominioOrden;
import net.royal.spring.framework.core.dominio.MensajeUsuario;
import net.royal.spring.framework.core.dominio.MensajeUsuario.tipo_mensaje;
import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.ParametroPersistenciaGenerico;
import net.royal.spring.framework.util.UInteger;
import net.royal.spring.framework.util.UString;
import net.royal.spring.framework.web.dao.GenericoDao;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
public abstract class GenericoDaoImpl<T, ID extends Serializable> extends HibernateTemplate
		implements GenericoDao<T, ID>, Serializable {


	private static final long serialVersionUID = 8704138686206423411L;
	private Class<T> persistentClass;
	private String nombreAlias;
	private Session sessionInterna;

	public GenericoDaoImpl(String nombreAlias) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.nombreAlias = nombreAlias;
	}
	public GenericoDaoImpl(SessionFactory factory, String nombreAlias) {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		super.setSessionFactory(factory);
		this.nombreAlias = nombreAlias;
	}
	
	@Override
	public T findId(ID key) {
		return (T) this.getSesionActual().get(persistentClass, key);
	}

	@Override
	public ID registrar(T entity) {
		return (ID) this.getSesionActual().save(entity);
	}

	public GenericoDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Criteria getCriteria() {
		return this.getSesionActual().createCriteria(persistentClass);
	}

	@Override
	public Criteria getCriteria(Class clazz) {
		return this.getSesionActual().createCriteria(clazz);
	}

	@Override
	public void actualizar(T entity) {
		this.getSesionActual().update(entity);
	}

	@Override
	public void eliminar(T entity) {
		this.getSesionActual().delete(entity);
	}
	
	public void eliminar(List<T> entitys) {
		for (T entity : entitys) {
			this.getSesionActual().delete(entity);
		}		
	}

	@Override
	public void registrarOactualizar(T entity) {
		this.getSesionActual().saveOrUpdate(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public T obtenerPorId(ID id, boolean lock) {
		T entity = null;
		try {
			if (lock) {
				entity = (T) this.getSesionActual().get(persistentClass, id, LockMode.UPGRADE);
			} else {
				entity = (T) this.getSesionActual().get(persistentClass, id);
			}
		} catch (Exception ex) {
			logger.error(ex);
			return null;
		}
		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public T obtenerPorId(ID id) {
		return this.obtenerPorId(id, true);
	}

	@Override
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parameters, Class clazz) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return null;
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parameters);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(String nombreQuery) {
		/* DIALECTO */
		return GenericoBase.buscarGenerico(nombreQuery, null, this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return GenericoBase.buscarGenerico(nombreQuery, parametros, this.getSesionActual(), nombreAlias);
	}

	@Override
	public void ejecutarPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return;
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		query.executeUpdate();
	}

	@Override
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query.executeUpdate();
	}

	@Override
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		System.out.println("ejecutando todo 1.0");
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		System.out.println("ejecutando todo 1.1");
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		System.out.println("ejecutando todo 1.2");
		System.out.println(query.toString());
		query.executeUpdate();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarTodos() {
		return listarPorCriterios();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarTodos(Class clazz) {
		return (List<Class>) listarPorCriterios(clazz);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorEjemplo(T exampleInstance, String... excludeProperty) {
		Criteria crit = this.getSesionActual().createCriteria(persistentClass);
		Example example = Example.create(exampleInstance);
		if (excludeProperty != null) {
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
		}
		crit.add(example);
		return crit.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery) {
		if (!GenericoBase.validarAlias(nombreAlias, nombreHqlQuery))
			return new ArrayList();
		logger.debug("listarPorHqlQuery");
		String sentenciaHql = this.getSesionActual().getNamedQuery(nombreHqlQuery).getQueryString();
		Query query = this.getSesionActual().createQuery(sentenciaHql);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery,
			List<ParametroPersistenciaGenerico> parametros) {
		if (!GenericoBase.validarAlias(nombreAlias, nombreHqlQuery))
			return new ArrayList();
		String sentenciaHql = this.getSesionActual().getNamedQuery(nombreHqlQuery).getQueryString();
		Query query = this.getSesionActual().createQuery(sentenciaHql);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorQuery(Class clazz, String nombreQuery) {

		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return new ArrayList();
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorQuery(Class clazz, String nombreQuery, List<ParametroPersistenciaGenerico> parameters) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return new ArrayList();
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parameters);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List listarPorQueryProcedimientoAlmacenado(String nombreQuery,
			List<ParametroPersistenciaGenerico> parameters) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return new ArrayList();

		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parameters);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarConPaginacion(Criteria criteria, ParametroPaginacionGenerico paginacion) {
		if (UInteger.esCeroOrNulo(paginacion.getPaginacionRegistroInicio()))
			paginacion.setPaginacionRegistroInicio(0);

		if (UInteger.esCeroOrNulo(paginacion.getPaginacionRegistrosPorPagina()))
			paginacion.setPaginacionRegistrosPorPagina(10);

		criteria.setFirstResult(paginacion.getPaginacionRegistroInicio());
		criteria.setMaxResults(paginacion.getPaginacionRegistrosPorPagina());

		logger.debug("listar con pagicacion criteria");

		if (!UValidador.estaVacio(paginacion.getPaginacionOrdenAtributo())) {
			if (UValidador.estaVacio(paginacion.getPaginacionOrdenDireccion()))
				paginacion.setPaginacionOrdenDireccion(SORT_ORDER.ASC);
			criteria.addOrder((paginacion.getPaginacionOrdenDireccion() == SORT_ORDER.ASC)
					? Order.asc(paginacion.getPaginacionOrdenAtributo())
					: Order.desc(paginacion.getPaginacionOrdenAtributo()));
		}
		return (List<T>) criteria.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return (List<T>) GenericoBase.listarConPaginacion(parametroPaginacion, parametros, null, persistentClass, null,
				this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery) {
		/* DIALECTO */
		return (List<T>) GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, persistentClass,
				null, this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz, null,
				this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz,
			String condicionesConsulta) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz,
				condicionesConsulta, this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Class> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros,
			Class clazz) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorCriterios(Class clazz, Criterion... criterion) {
		Criteria crit = this.getSesionActual().createCriteria(clazz);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> listarPorCriterios(Criterion... criterion) {
		Criteria crit = this.getSesionActual().createCriteria(persistentClass);
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@Override
	public List<T> listarPorCriterios(Criteria criteria) {
		return criteria.list();
	}

	@Override
	public List listarPorSentenciaSQLGenerica(StringBuilder sentenciaSQL) {
		return listarPorSentenciaSQLGenerica(sentenciaSQL, null);
	}

	@Override
	public List listarPorSentenciaSQLGenerica(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros) {
		if (parametros != null) {

			/*
			 * Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
			 * query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
			 * sentenciaSQL = new StringBuilder(query.toString());
			 */
			sentenciaSQL = GenericoBase.getNamedQueryByPatametersSet(sentenciaSQL, parametros);
			return GenericoBase.listarPorSentenciaSQLGenerica(sentenciaSQL, this.getConnection());
		} else {
			return GenericoBase.listarPorSentenciaSQLGenerica(sentenciaSQL, this.getConnection());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, null, this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, parametros, this.getSesionActual(), nombreAlias);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer contar(List<ParametroPersistenciaGenerico> parametros) {
		return GenericoBase.contar(parametros, this.getSesionActual(), persistentClass);
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		return contarPorSentenciaSQL(sentenciaSQL, null);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL) {
		return contarPorSentenciasSQL(sentenciaSQL, null);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		return (Integer) query.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		return (BigDecimal) query.uniqueResult();
	}

	@Override
	public String obtenerSentenciaSqlPorQuery(String nombreQuery) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return null;
		StringBuilder queryS = new StringBuilder();
		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());
		return queryS.toString();
	}

	@Override
	public Session getSesionActual() {
		if (sessionInterna == null) {
			return super.getSessionFactory().getCurrentSession();
		} else {
			return sessionInterna;
		}
	}

	@Override
	public void setSesionActual(Session sessionInterna) {
		this.sessionInterna = sessionInterna;
	}

	public Connection getConnection() {
		return ((SessionImpl) this.getSesionActual()).connection();
	}

	@Override
	@Transactional(readOnly = true)
	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros,String cadenaConexion) throws Exception {
		Connection conexion;
		conexion = DriverManager.getConnection(cadenaConexion); 
		return ejecutarReporteComoPDF(rutaArchivoReporteFuente,parametros,conexion);
	}
	
	@Override
	@Transactional(readOnly = true)
	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros) throws Exception {
		Connection conexion;
		conexion = ((SessionImpl) getSesionActual()).connection();
		return ejecutarReporteComoPDF(rutaArchivoReporteFuente,parametros,conexion);
	}
	
	private byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros,Connection conexion) throws Exception {
		byte[] bytReporte = null;
		bytReporte = JasperRunManager.runReportToPdf(rutaArchivoReporteFuente, parametros, conexion);
		return bytReporte;
	}
	

	@Override
	@Transactional(readOnly = true)
	public byte[] ejecutarReporteComoPDFDesdeLista(String rutaArchivoReporteFuente, Map parametros, List lista) {
		byte[] bytes2 = null;
		try {
			bytes2 = JasperRunManager.runReportToPdf(rutaArchivoReporteFuente, parametros,
					new JRBeanCollectionDataSource(lista));
		} catch (Exception ex) {
			logger.error(ex);
		}
		return bytes2;
	}

	/**
	 * 
	 * @param cri
	 * @return Integer
	 */
	public Integer incrementarInteger(Criteria cri) {
		/* EN USO */
		List results = cri.list();

		if (results == null)
			return 1;
		if (results.size() == 0)
			return 1;

		Integer obj = (Integer) results.get(0);
		if (obj == null)
			return 1;

		return obj + 1;

		/*
		 * List results = cri.list();
		 * 
		 * Integer total = results.size();
		 * 
		 * if (results.size() == 0) return 1;
		 * 
		 * return total + 1;
		 */
	}

	public Integer incrementarStringInteger(Criteria cri) {

		List results = cri.list();

		if (results == null)
			return 1;
		if (results.size() == 0)
			return 1;

		String objString = (String) results.get(0);

		if (objString == null)
			return 1;

		Integer obj = Integer.parseInt(objString.trim());

		return obj + 1;

	}

	public BigDecimal incrementarBigDecimal(Criteria cri) {
		List results = cri.list();

		if (results == null)
			return new BigDecimal(1);
		if (results.size() == 0)
			return new BigDecimal(1);

		BigDecimal obj = (BigDecimal) results.get(0);
		if (obj == null)
			return new BigDecimal(1);

		return obj.add(new BigDecimal(1));
	}

	public Criteria agregarParametrosACriteria(List<ParametroPersistenciaGenerico> parametros, Criteria criteria) {
		/* EN USO */
		return agregarParametrosACriteria(parametros, criteria, null);
	}

	/**
	 * considerar que el listado que use esta generacion de parametros podria usar
	 * un listado que genere de nuevo order by
	 **/
	public Criteria agregarParametrosACriteria(List<ParametroPersistenciaGenerico> parametros, Criteria criteria,
			DominioOrden filtroOrden) {
		/* EN USO */
		for (ParametroPersistenciaGenerico param : parametros) {
			if (UValidador.esNulo(param.getValor()))
				continue;
			if (UValidador.estaVacio(param.getValor().toString()))
				continue;

			if (UValidador.esNulo(param.getOperacion()))
				param.setOperacion(TIPO_OPERACION.EQ);

			if (param.getOperacion().equals(TIPO_OPERACION.EQ))
				criteria.add(Restrictions.eq(param.getCampo(), param.getValor()));
			else if (param.getOperacion().equals(TIPO_OPERACION.LIKE))
				criteria.add(Restrictions.like(param.getCampo(), param.getValor().toString(), MatchMode.ANYWHERE)
						.ignoreCase());
		}

		if (filtroOrden != null) {
			if (!UValidador.estaVacio(filtroOrden.getAtributoOrdenar())) {
				if (UValidador.estaVacio(filtroOrden.getDireccionOrdenAtributo()))
					filtroOrden.setDireccionOrdenAtributo(SORT_ORDER.ASC);
				criteria.addOrder((filtroOrden.getDireccionOrdenAtributo() == SORT_ORDER.ASC)
						? Order.asc(filtroOrden.getAtributoOrdenar())
						: Order.desc(filtroOrden.getAtributoOrdenar()));
			}
		}

		return criteria;
	}

	@Override
	public Integer contarPorCriteria(Criteria criteria) {
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		if (count == null)
			return 0;
		return count.intValue();
	}
	
	@Autowired
	public ApplicationContext appContext;

	@Autowired
	private MessageSource messageSource;
	
	public MensajeUsuario getMsjUsuarioError(String msgCode) {
		String msg = getMessage(msgCode);
		MensajeUsuario msj = new MensajeUsuario(tipo_mensaje.ERROR, msg);
		return msj;
	}
	public String getMessage(String msgCode) {
		Locale locale = LocaleContextHolder.getLocale();
		return getMessageBase(msgCode, null, null, locale);
	}
	private String getMessageBase(String msgCode, Object[] params, String defaultMsg, Locale locale) {
		try {
			if (locale == null)
				locale = LocaleContextHolder.getLocale();
			defaultMsg = UString.esNuloVacio(defaultMsg) ? msgCode : defaultMsg;
			String msg = messageSource.getMessage(msgCode, params, defaultMsg, locale);
			return UString.esNuloVacio(msg) ? msgCode : msg;
		} catch (Exception e) {
			logger.error(msgCode);
		}
		return msgCode;
	}
	public List<MensajeUsuario> setMessageError(List<MensajeUsuario> lst,String msg) {
		if (lst==null)
			lst=new ArrayList<>();
		lst.add(new MensajeUsuario(tipo_mensaje.ERROR, msg));
		return lst;
	}
}
