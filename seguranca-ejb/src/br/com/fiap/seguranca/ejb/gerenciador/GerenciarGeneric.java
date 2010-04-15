/**
 * 
 */
package br.com.fiap.seguranca.ejb.gerenciador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import br.com.fiap.seguranca.domain.entity.EntityBasic;
import br.com.fiap.seguranca.ejb.exceptions.GerenciadorException;
import br.com.fiap.seguranca.ejb.gerenciador.interfaces.GerenciadorBasic;

/**
 * @author leandro.goncalves
 *
 */

public abstract class GerenciarGeneric<T extends EntityBasic> implements GerenciadorBasic<T> {

	@PersistenceContext(unitName = "fiap-seguranca")
	EntityManager entityManager;

	public void delete(T t) throws GerenciadorException{
		entityManager.remove(t);
	}

	@SuppressWarnings("unchecked")
	public T find(T t) throws GerenciadorException{
		return (T) entityManager.find(t.getClass(), t.getId());
	}

	public T insert(T t) throws GerenciadorException{
		entityManager.persist(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> selectAll(Class<T> c) throws GerenciadorException{
		entityManager.getTransaction().begin();
		return ((Session)entityManager.getDelegate()).createCriteria(c).list();
	}

	public T update(T t) throws GerenciadorException{
		return entityManager.merge(t);
	}
}
