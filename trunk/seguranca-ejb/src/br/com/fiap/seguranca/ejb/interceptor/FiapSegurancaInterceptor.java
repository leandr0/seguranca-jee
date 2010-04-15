/**
 * 
 */
package br.com.fiap.seguranca.ejb.interceptor;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author leandro.goncalves
 *
 */
public class FiapSegurancaInterceptor {

	@Resource 
	private EJBContext ejbContext;
	
	private static final Log LOG = LogFactory.getLog(FiapSegurancaInterceptor.class);
	
	@AroundInvoke
	public Object logDataBase(InvocationContext context) throws Exception{
		
		LOG.info("Usuário : [ "+ejbContext.getCallerPrincipal().getName()+" ] --> acessando método : [ "+context.getMethod().getName()+" ]");
		
        return context.proceed();
	}
}