/**
 * 
 */
package br.com.fiap.seguranca.ejb.interfaces.local;

/**
 * @author leandro.goncalves
 * 
 */
public interface LocalValidator {
	
	/**
	 * 
	 * @return {@link Boolean}
	 */
	public boolean isValid();

	/**
	 * 
	 * @return {@link String}
	 */
	public String getMessageValidator();
}
