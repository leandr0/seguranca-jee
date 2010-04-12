/**
 * 
 */
package br.com.fiap.seguranca.domain.entity;

import java.io.Serializable;

/**
 * @author leandro.goncalves
 *
 */
public interface EntityBasic extends Serializable{

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id);
	
	/**
	 * 
	 * @return
	 */
	public Long getId();
}
