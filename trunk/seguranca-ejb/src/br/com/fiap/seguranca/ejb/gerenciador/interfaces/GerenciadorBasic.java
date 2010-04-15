/**
 * 
 */
package br.com.fiap.seguranca.ejb.gerenciador.interfaces;

import java.util.List;

import br.com.fiap.seguranca.domain.entity.EntityBasic;
import br.com.fiap.seguranca.ejb.exceptions.GerenciadorException;

/**
 * @author leandro.goncalves
 *
 */
public interface GerenciadorBasic<T extends EntityBasic> {

	/**
	 * 
	 * @param t
	 * @return
	 * @throws GerenciadorException
	 */
	public T insert(T t)throws GerenciadorException;
	
	/**
	 * 
	 * @param t
	 * @throws GerenciadorException
	 */
	public void delete(T t)throws GerenciadorException;
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws GerenciadorException
	 */
	public T update(T t)throws GerenciadorException;
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws GerenciadorException
	 */
	public T find(T t)throws GerenciadorException;
	
	/**
	 * 
	 * @param c
	 * @return
	 * @throws GerenciadorException
	 */
	public List<T> selectAll(Class<T> c)throws GerenciadorException;
}
