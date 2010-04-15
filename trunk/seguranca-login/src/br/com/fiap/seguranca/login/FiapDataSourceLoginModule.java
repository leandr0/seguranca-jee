/**
 * 
 */
package br.com.fiap.seguranca.login;

import java.security.acl.Group;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

import br.com.fiap.seguranca.login.jdbc.FiapLoginJDBC;
import br.com.fiap.seguranca.login.jdbc.LoginJDBC;
import br.com.fiap.seguranca.login.model.LoginModel;
import br.com.fiap.seguranca.util.criptografia.CriptografiaUtil;

/**
 * @author leandro.goncalves
 *
 */
public class FiapDataSourceLoginModule extends UsernamePasswordLoginModule {

	private static final Log LOG = LogFactory.getLog(FiapDataSourceLoginModule.class);
	
	/**
	 * nome do datasource
	 */
	private String dataSoureJndi; 

	private LoginModel loginModel;
	
	private LoginJDBC loginJDBC;
	
	/*
	 * (non-Javadoc)
	 * @see org.jboss.security.auth.spi.UsernamePasswordLoginModule#initialize(javax.security.auth.Subject, javax.security.auth.callback.CallbackHandler, java.util.Map, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(Subject subject, CallbackHandler cbh,
			Map sharedState, Map options) {

		LOG.info("Inicializando JAAS customizado");
		
		super.initialize(subject, cbh, sharedState, options);
		
		LOG.info("Recuperando JNDI DataSource");
		dataSoureJndi = (String) options.get("dsJndiName");
		
		loginJDBC = new FiapLoginJDBC(dataSoureJndi);
		
		LOG.info("Datasource  : [ "+ dataSoureJndi+" ]");
	}

	/*
	 * (non-Javadoc)
	 * @see org.jboss.security.auth.spi.UsernamePasswordLoginModule#validatePassword(java.lang.String, java.lang.String)
	 */
	@Override
	protected boolean validatePassword(String inputPassword,
			String expectedPassword) {
		LOG.info("Validando Senha");
		try{
			inputPassword = CriptografiaUtil.criptografar(inputPassword);
		}catch (Exception e) {
			LOG.error("Erro ao criptografar senha");
		}
		return super.validatePassword(inputPassword, expectedPassword);
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.security.auth.spi.AbstractServerLoginModule#getRoleSets()
	 */
	@Override
	protected Group[] getRoleSets() throws LoginException {

		LOG.info("Obtendo papeis");
		
		if(loginModel != null){

			SimpleGroup simpleGroup = new SimpleGroup("Roles");

			SimplePrincipal simplePrincipal = new SimplePrincipal(loginModel.getRole());

			simpleGroup.addMember(simplePrincipal);

			return new Group[] { simpleGroup };
		}

		return new Group[0];
	}

	/* (non-Javadoc)
	 * @see org.jboss.security.auth.spi.UsernamePasswordLoginModule#getUsersPassword()
	 */
	@Override
	protected String getUsersPassword() throws LoginException {
		try{

			LOG.info("Obtendo password");

			LOG.info("Login : [ " + this.getUsername()+" ]");
			
			executeLogin();

			return loginModel.getSenha();
			
		}catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	private void executeLogin()throws Exception{
		LOG.info("Executando Login");
		loginModel = loginJDBC.executeLogin(this.getUsername());
	}

}