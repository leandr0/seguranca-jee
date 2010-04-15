/**
 * 
 */
package br.com.fiap.seguranca.util.criptografia;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xml.internal.security.utils.Base64;


/**
 * @author leandro.goncalves
 *
 */
public class CriptografiaUtil {

	public static String criptografar(String value) throws NoSuchAlgorithmException{
		
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.reset();

		byte[] bytes = value.getBytes();
		bytes = md5.digest(bytes);

		return Base64.encode(bytes);
		
	}
}
