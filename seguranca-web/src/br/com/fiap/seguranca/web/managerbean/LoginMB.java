/**
 * 
 */
package br.com.fiap.seguranca.web.managerbean;

/**
 * @author leandro.goncalves
 *
 */
public class LoginMB extends ManagerBean{


	/**
	 * Executa o logout da aplicacao
	 * @return {@link String}
	 */
	public String logout(){
		
		session.invalidate();
		
		return "menu";
	}

	
}
