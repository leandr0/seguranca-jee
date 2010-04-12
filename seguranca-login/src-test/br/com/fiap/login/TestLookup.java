/**
 * 
 */
package br.com.fiap.login;

import java.sql.Connection;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author leandro.goncalves
 *
 */
public class TestLookup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InitialContext initialContext = null;
		DataSource dataSource = null;

		try{

			Properties props = new Properties();
			props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			props.setProperty("java.naming.provider.url", "localhost:1099");

			initialContext = new InitialContext(props);
			dataSource = (DataSource) initialContext.lookup("java:fiap-seguranca");
			Connection conn = dataSource.getConnection();
			conn.close();
			System.out.println("Conectado **************");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			dataSource = null;

			if(initialContext!=null) {
				try {
					initialContext.close();
				} catch(Exception e) {
					e.printStackTrace();
				} 
			}
		}	
	}
}
