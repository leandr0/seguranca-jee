/**
 * 
 */
package br.com.fiap.seguranca.ejb.exceptions;

import javax.ejb.EJBException;

/**
 * @author leandro.goncalves
 *
 */
public class GerenciadorException extends EJBException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1794886222329016344L;

	/**
	 * 
	 */
	public GerenciadorException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public GerenciadorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ex
	 */
	public GerenciadorException(Exception ex) {
		super(ex);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param ex
	 */
	public GerenciadorException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
