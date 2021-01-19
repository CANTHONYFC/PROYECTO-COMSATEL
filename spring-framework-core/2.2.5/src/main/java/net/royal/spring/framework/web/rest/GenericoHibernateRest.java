package net.royal.spring.framework.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.ParametroPersistenciaGenerico;
import net.royal.spring.framework.web.dao.impl.GenericoBase;

public class GenericoHibernateRest extends GenericoRest {

	private String nombreAlias;
	private Session sessionInterna;
	private SessionFactory factory;

	public GenericoHibernateRest(String nombreAlias) {
		this.nombreAlias = nombreAlias;
	}

	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSesionActual() {
		if (sessionInterna == null) {
			return factory.getCurrentSession();
		} else {
			return sessionInterna;
		}
	}

	/**********/
	public List<Class> listarPorQuery(Class clazz, String nombreQuery) {

		/* DIALECTO */
		nombreQuery = GenericoBase.nombreQueryDialecto(this.getSesionActual(), nombreQuery);

		if (!GenericoBase.validarAlias(nombreAlias, nombreQuery))
			return new ArrayList();
		Query query = this.getSesionActual().getNamedQuery(nombreQuery);
		query = query.setResultTransformer(Transformers.aliasToBean(clazz));
		return query.list();
	}

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

	/********/

	public Integer contar(String nombreQuery) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, null, this.getSesionActual(), nombreAlias);
	}

	public Integer contar(String nombreQuery, List<ParametroPersistenciaGenerico> parametros) {
		/* DIALECTO */
		return GenericoBase.contar(nombreQuery, parametros, this.getSesionActual(), nombreAlias);
	}

	/********/
	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz, null,
				this.getSesionActual(), nombreAlias);
	}

	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz,
			String condicionesConsulta) {
		/* DIALECTO */
		return GenericoBase.listarConPaginacion(parametroPaginacion, parametros, nombreQuery, clazz,
				condicionesConsulta, this.getSesionActual(), nombreAlias);
	}
	/********/
}
