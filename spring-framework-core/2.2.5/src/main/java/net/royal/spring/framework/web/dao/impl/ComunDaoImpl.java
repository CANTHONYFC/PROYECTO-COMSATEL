package net.royal.spring.framework.web.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.royal.spring.framework.web.dao.ComunDao;

@Repository
public class ComunDaoImpl extends GenericoDaoImpl<Object, Long> implements ComunDao {

	private static final long serialVersionUID = 1068424617811161830L;

	@Resource(name = "sessionFactory")
	public void asignarSessionFactory(SessionFactory factory) {
		super.setSessionFactory(factory);
	}

}
