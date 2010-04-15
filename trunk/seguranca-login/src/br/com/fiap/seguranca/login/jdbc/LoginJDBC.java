/**
 * 
 */
package br.com.fiap.seguranca.login.jdbc;

import br.com.fiap.seguranca.login.model.LoginModel;

/**
 * @author leandro.goncalves
 *
 */
public interface LoginJDBC {

	
	public LoginModel executeLogin(String username); 
}
