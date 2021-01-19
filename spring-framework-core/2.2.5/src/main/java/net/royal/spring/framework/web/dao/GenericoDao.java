package net.royal.spring.framework.web.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import net.royal.spring.framework.core.dominio.ParametroPaginacionGenerico;
import net.royal.spring.framework.core.dominio.ParametroPersistenciaGenerico;

@SuppressWarnings("rawtypes")
public interface GenericoDao<T, ID extends Serializable> {

	public Criteria getCriteria();

	public Criteria getCriteria(Class clazz);

	public ID registrar(T entity);

	public void actualizar(T entity);

	public void eliminar(T entity);
	
	public void eliminar(List<T> entitys);

	public void registrarOactualizar(T entity);

	public T obtenerPorId(ID id, boolean lock);

	public T obtenerPorId(ID id);

	public T findId(ID key);

	public Object obtenerPorQuery(String namedQuery, List<ParametroPersistenciaGenerico> parameters, Class clazz);

	public Object obtenerPorQuery(String nombreQuery);

	public Object obtenerPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros);

	public void ejecutarPorQuery(String nombreQuery, List<ParametroPersistenciaGenerico> parametros);

	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL);

	public void ejecutarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros);

	public List<T> listarTodos();

	public List<Class> listarTodos(Class clazz);

	public List<T> listarPorEjemplo(T exampleInstance, String... excludeProperty);

	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery);

	public List<Class> listarPorHqlQuery(Class clazz, String nombreHqlQuery,
			List<ParametroPersistenciaGenerico> parametros);

	public List<Class> listarPorQuery(Class clazz, String namedQuery);

	public List<Class> listarPorQuery(Class clazz, String namedQuery, List<ParametroPersistenciaGenerico> parameters);

	public List<T> listarConPaginacion(Criteria criteria, ParametroPaginacionGenerico paginacion);

	public List<T> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros);

	public List<T> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery);

	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz);

	public List<Class> listarConPaginacion(ParametroPaginacionGenerico parametroPaginacion,
			List<ParametroPersistenciaGenerico> parametros, String nombreQuery, Class clazz,
			String condicionesConsulta);

	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL);

	public List<T> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros);

	public List<Class> listarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros,
			Class clazz);

	public List<T> listarPorCriterios(Class clazz, Criterion... criterion);

	public List<T> listarPorCriterios(Criterion... criterion);

	public List<T> listarPorCriterios(Criteria criteria);

	public List listarPorSentenciaSQLGenerica(StringBuilder sentenciaSQL);

	public List listarPorSentenciaSQLGenerica(StringBuilder sentenciaSQL,
			List<ParametroPersistenciaGenerico> parametros);

	public Integer contar(String nombreQuery);

	public Integer contar(String nombreQuery, List<ParametroPersistenciaGenerico> parametros);

	public Integer contar(List<ParametroPersistenciaGenerico> parametros);

	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL);

	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL);

	public Integer contarPorSentenciasSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros);

	public BigDecimal contarPorSentenciaSQL(StringBuilder sentenciaSQL, List<ParametroPersistenciaGenerico> parametros);

	public String obtenerSentenciaSqlPorQuery(String nombreQuery);

	public Session getSesionActual();

	public void setSesionActual(Session sessionInterna);

	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros,String cadenaConexion) throws Exception;
	
	public byte[] ejecutarReporteComoPDF(String rutaArchivoReporteFuente, Map parametros) throws Exception;

	public byte[] ejecutarReporteComoPDFDesdeLista(String rutaArchivoReporteFuente, Map parametros, List lista);

	public Integer incrementarInteger(Criteria cri);

	public BigDecimal incrementarBigDecimal(Criteria cri);

	public Integer contarPorCriteria(Criteria criteria);

	public SessionFactory getSessionFactory();

	public List listarPorQueryProcedimientoAlmacenado(String nombreQuery,
			List<ParametroPersistenciaGenerico> parameters);
}
