/**
 * 
 */
package br.com.fiap.seguranca.ejb.test;

import java.security.MessageDigest;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.naming.NamingException;

import org.apache.xml.security.utils.Base64;

/**
 * @author leandro.goncalves
 *
 */
public class Client {

	public static void main(String[] args) {

		/*Properties properties = new Properties();
		properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		properties.put("java.naming.factory.url.pkgs", "=org.jboss.naming:org.jnp.interfaces");
		properties.put("java.naming.provider.url", "localhost:1099");

		Context context;*/
		try {

			/*context = new InitialContext(properties);

			CadastrarFuncionarioRemote chamadoRemote = (CadastrarFuncionarioRemote) context.lookup("CadastrarFuncionarioBean/remote");
*/			
			
			
			/*String senha = "gerente";
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			byte[] bytes = senha.getBytes();
			bytes = md5.digest(bytes);
			String senhaCripto = Base64.encode(bytes);
			
			System.out.println(senhaCripto);
			System.out.println(bytes);*/
			
			Calendar calendar = GregorianCalendar.getInstance();
			
			String date = String.valueOf(calendar.get(calendar.HOUR_OF_DAY)+":");
			date = date.concat(String.valueOf(calendar.get(calendar.MINUTE)+":"));
			date = date.concat(String.valueOf(calendar.get(calendar.SECOND)));
			
			System.out.println(date);
			
			String hora = String.valueOf(calendar.get(calendar.DAY_OF_MONTH)+"/");
			hora = hora.concat(String.valueOf(calendar.get(calendar.MONTH))+"/");
			hora = hora.concat(String.valueOf(calendar.get(calendar.YEAR)));
			
			System.out.println(hora);
			
			//System.out.println(chamadoRemote.getConnection());


		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
