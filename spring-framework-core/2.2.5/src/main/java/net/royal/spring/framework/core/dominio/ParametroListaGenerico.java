package net.royal.spring.framework.core.dominio;

import java.util.ArrayList;
import java.util.List;

public class ParametroListaGenerico extends ArrayList<Object> {

	private static final long serialVersionUID = -4612932741323122484L;

	public void parametroAgregar(String pfield, Class<?> pclazz, Object pvalue) {
		this.parametroRemover(pfield);
		ParametroPersistenciaGenerico e = null;
		e = new ParametroPersistenciaGenerico(pfield, pclazz, pvalue);
		this.add(e);
	}

	public void parametroAgregarLista(List<ParametroPersistenciaGenerico> lista) {
		if (lista == null)
			return;
		for (ParametroPersistenciaGenerico bean : lista) {
			this.parametroAgregar(bean.getCampo(), bean.getClase(), bean.getValor());
		}
	}

	public Object get(String parametro) {
		Object retorno = null;

		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					return bean.getValor();
			}
		}
		return retorno;
	}

	public ParametroPersistenciaGenerico parametroObtener(String parametro) {
		ParametroPersistenciaGenerico retorno = null;

		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					return bean;
			}
		}
		return retorno;
	}

	public Integer parametroObtenerInteger(String parametro) {
		Integer retorno = null;

		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					return (Integer) bean.getValor();
			}
		}
		return retorno;
	}

	public Object parametroObtenerObject(String parametro) {
		Object retorno = null;

		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					return bean.getValor();
			}
		}
		return retorno;
	}

	public String parametroObtenerString(String parametro) {
		String retorno = null;

		if (this.size() == 0)
			return null;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					return (String) bean.getValor();
			}
		}
		return retorno;
	}

	public void parametroRemover(String parametro) {

		if (this.size() == 0)
			return;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean;
			bean = (ParametroPersistenciaGenerico) this.get(index);
			if (bean != null) {
				if (bean.getCampo().equals(parametro))
					this.remove(index);
			}
		}
	}

	public void parametroImprimirValores() {
		if (this.size() == 0)
			return;

		for (int index = 0; index < this.size(); index++) {
			ParametroPersistenciaGenerico bean = (ParametroPersistenciaGenerico) this.get(index);
			System.out.println(bean.getCampo() + "-" + bean.getValor());
		}
	}

}