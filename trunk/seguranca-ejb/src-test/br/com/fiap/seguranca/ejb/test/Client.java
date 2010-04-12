/**
 * 
 */
package br.com.fiap.seguranca.ejb.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.seguranca.ejb.interfaces.remote.CadastrarFuncionarioRemote;

/**
 * @author leandro.goncalves
 *
 */
public class Client {

	public static void main(String[] args) {

		Properties properties = new Properties();
		properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs", "=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context;
		try {

			context = new InitialContext(properties);

			CadastrarFuncionarioRemote chamadoRemote = (CadastrarFuncionarioRemote) context.lookup("CadastrarFuncionarioBean/remote");
			
			
			//System.out.println(chamadoRemote.getConnection());


		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
