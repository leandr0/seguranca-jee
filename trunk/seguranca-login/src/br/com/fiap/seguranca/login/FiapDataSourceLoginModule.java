/**
 * 
 */
package br.com.fiap.seguranca.login;

import java.security.acl.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

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

	/**
	 * Senha usuário
	 */
	private String password;

	/**
	 * Papel do usuário 
	 */
	private String role;

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
		
		LOG.info("Datasource  "+ dataSoureJndi);
	}

	/*
	 * (non-Javadoc)
	 * @see org.jboss.security.auth.spi.UsernamePasswordLoginModule#validatePassword(java.lang.String, java.lang.String)
	 */
	@Override
	protected boolean validatePassword(String inputPassword,
			String expectedPassword) {
		LOG.info("Validando Senha");
		return super.validatePassword(inputPassword, expectedPassword);
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.security.auth.spi.AbstractServerLoginModule#getRoleSets()
	 */
	@Override
	protected Group[] getRoleSets() throws LoginException {

		LOG.info("Obtendo papeis");
		
		if(role != null){

			SimpleGroup simpleGroup = new SimpleGroup("Roles");

			SimplePrincipal simplePrincipal = new SimplePrincipal(role);

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

			LOG.info("Login : " + this.getUsername());

			executeLogin();

			return password;
			
		}catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	private void executeLogin()throws Exception{
		LOG.info("Executando Login");
		getConnection();
	}
	
	
	private void executeQuery(Connection connection) throws Exception{

		LOG.info("Executando query");
		
		String sql = "SELECT SEG.SENHA , FUNC.PERFIL FROM SEGURANCA SEG " +
					" INNER JOIN FUNCIONARIO FUNC "+
					" ON SEG.ID = FUNC.SEGURANCA_ID "+
					" WHERE LOGIN = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1 , this.getUsername());

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			LOG.info("Obtendo resultado da query");
			password = resultSet.getString(1);
			role	 = resultSet.getString(2);
		}

		preparedStatement.close();
		resultSet.close();
		preparedStatement.close();
	}

	private void getConnection() throws Exception {

		Context 	context 	= null;
		DataSource 	dataSource	= null;
		Connection 	connection	= null;
		
		try {
			
			LOG.info("Fazendo lookup do dataSource");
			
			Properties props = new Properties();
			props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			props.setProperty("java.naming.provider.url", "localhost:1099");

			context = new InitialContext();
			dataSource = (javax.sql.DataSource)context.lookup(dataSoureJndi);
			
			LOG.info("Obtendo conexao");
			connection = dataSource.getConnection();
			
			executeQuery(connection);
			
		}finally {
			
			LOG.info("Finalizando Conexao e Contexto ");
			
			if(connection != null && !connection.isClosed())
				connection.close();
			
			dataSource = null;

			if(context!=null) {
				try {
					context.close();
				} catch(Exception e) {
					e.printStackTrace();
				} 
			}
		}
	}	
}