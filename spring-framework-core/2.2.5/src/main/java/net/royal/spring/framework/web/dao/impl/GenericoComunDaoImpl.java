package net.royal.spring.framework.web.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.ParametroPersistenciaGenerico;

@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
public class GenericoComunDaoImpl extends HibernateTemplate {


	private static final long serialVersionUID = 8704138686206423411L;
	private String nombreAlias;
	private Session sessionInterna;

	public GenericoComunDaoImpl(String nombreAlias) {		
		this.nombreAlias = nombreAlias;
	}
	public GenericoComunDaoImpl(SessionFactory factory, String nombreAlias) {
		super.setSessionFactory(factory);
		this.nombreAlias = nombreAlias;
	}	

	public GenericoComunDaoImpl() {		
	}

	
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

	
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(String nombreQuery) {
		/* DIALECTO */
		return GenericoBase.buscarGenerico(nombreQuery, null, this.getSesionActual(), nombreAlias);
	}

	
	@Transactional(readOnly = true)
	public Object obtenerPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return GenericoBase.buscarGenerico(nombreQuery, parametros, this.getSesionActual(), nombreAlias);
	}

	
	public void ejecutarPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return;
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		query.executeUpdate();
	}

	
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query.executeUpdate();
	}

	
	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		System.out.println("ejecutando todo 1.0");
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		System.out.println("ejecutando todo 1.1");
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		System.out.println("ejecutando todo 1.2");
		System.out.println(query.toString());
		query.executeUpdate();
	}

	
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

	
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz, null,
				this.getSesionActual(), nombreAlias);
	}

	
	@Transactional(readOnly = true)
	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz,
			String condicionesConsulta) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz,
				condicionesConsulta, this.getSesionActual(), nombreAlias);
	}
	
	@Transactional(readOnly = true)
	public List<Class> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros,
			Class clazz) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

	

	
	public List listarPorSentenciaSQLGenerica(StringBuilder sentenciaSQL) {
		return listarPorSentenciaSQLGenerica(sentenciaSQL, null);
	}

	
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

	
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, null, this.getSesionActual(), nombreAlias);
	}

	
	@Transactional(readOnly = true)
	public Integer contar(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, parametros, this.getSesionActual(), nombreAlias);
	}

	
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL) {
		return contarPorSentenciaSQL(sentenciaSQL, null);
	}

	
	@Transactional(readOnly = true)
	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL) {
		return contarPorSentenciasSQL(sentenciaSQL, null);
	}

	
	@Transactional(readOnly = true)
	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		return (Integer) query.uniqueResult();
	}

	
	@Transactional(readOnly = true)
	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros) {
		Query query = this.getSesionActual().createSQLQuery(sentenciaSQL.toString());
		query = GenericoBase.getNamedQueryByPatametersSet(query, parametros);
		return (BigDecimal) query.uniqueResult();
	}

	
	public String obtenerSentenciaSqlPorQuery(String nombreQuery) {
		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return null;
		StringBuilder queryS = new StringBuilder();
		queryS.append(this.getSesionActual().getNamedQuery(nombreQuery).getQueryString());
		return queryS.toString();
	}

	
	public Session getSesionActual() {
		if (sessionInterna == null) {
			return super.getSessionFactory().getCurrentSession();
		} else {
			return sessionInterna;
		}
	}

	
	public void setSesionActual(Session sessionInterna) {
		this.sessionInterna = sessionInterna;
	}

	public Connection getConnection() {
		return ((SessionImpl) this.getSesionActual()).connection();
	}

}
