/**
 * 
 */
package br.com.fiap.seguranca.ejb.interfaces.remote;

/**
 * @author leandro.goncalves
 *
 */
public interface RemoteValidator {

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
