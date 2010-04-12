/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao.interfaces;

import java.util.List;

import br.com.fiap.seguranca.domain.entity.EntityBasic;
import br.com.fiap.seguranca.ejb.exceptions.DAOException;

/**
 * @author leandro.goncalves
 *
 */
public interface BasicDAO<T extends EntityBasic> {

	/**
	 * 
	 * @param t
	 * @return
	 * @throws DAOException
	 */
	public T insert(T t)throws DAOException;
	
	/**
	 * 
	 * @param t
	 * @throws DAOException
	 */
	public void delete(T t)throws DAOException;
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws DAOException
	 */
	public T update(T t)throws DAOException;
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws DAOException
	 */
	public T find(T t)throws DAOException;
	
	/**
	 * 
	 * @param c
	 * @return
	 * @throws DAOException
	 */
	public List<T> selectAll(Class<T> c)throws DAOException;
}
