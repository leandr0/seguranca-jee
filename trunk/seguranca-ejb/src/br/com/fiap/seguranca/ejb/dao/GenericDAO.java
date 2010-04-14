/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.fiap.seguranca.domain.entity.EntityBasic;
import br.com.fiap.seguranca.ejb.dao.interfaces.BasicDAO;
import br.com.fiap.seguranca.ejb.exceptions.DAOException;

/**
 * @author leandro.goncalves
 *
 */

public abstract class GenericDAO<T extends EntityBasic> implements BasicDAO<T> {

	@PersistenceContext(unitName = "fiap-seguranca")
	EntityManager entityManager;

	public void delete(T t) throws DAOException{
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	public T find(T t) throws DAOException{
		return (T) entityManager.find(t.getClass(), t.getId());
	}

	public T insert(T t) throws DAOException{
		entityManager.persist(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll(Class<T> c) throws DAOException{
		entityManager.getTransaction().begin();
		return ((Session)entityManager.getDelegate()).createCriteria(c).list();
	}

	public T update(T t) throws DAOException{
		return entityManager.merge(t);
	}
}
