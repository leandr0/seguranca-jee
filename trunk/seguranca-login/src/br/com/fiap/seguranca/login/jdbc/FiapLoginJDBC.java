/**
 * 
 */
package br.com.fiap.seguranca.login.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiap.seguranca.login.model.LoginModel;

/**
 * @author leandro.goncalves
 *
 */
public class FiapLoginJDBC implements LoginJDBC{

	private static final Log LOG = LogFactory.getLog(FiapLoginJDBC.class);

	private Connection connection;

	private String dataSoureJndi;

	private Context 	context;
	
	private DataSource 	dataSource;
	
	public FiapLoginJDBC(String dataSoureJndi) {
		this.dataSoureJndi = dataSoureJndi;
	}

	private LoginModel executeQuery(String username) throws SQLException, NamingException {

		LOG.info("Executando query");

		LoginModel model = null;

		String sql = "SELECT SEG.SENHA , FUNC.PERFIL FROM SEGURANCA SEG " +
		" INNER JOIN FUNCIONARIO FUNC "+
		" ON SEG.ID = FUNC.SEGURANCA_ID "+
		" WHERE LOGIN = ?";

		
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1 , username);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			LOG.info("Obtendo resultado da query");
			model = new LoginModel(resultSet.getString(1),
					resultSet.getString(2));
		}

		LOG.info("Papel : [ "+model.getRole()+" ]");

		resultSet.close();
		preparedStatement.close();
		
		insertLOG(username);

		return model;
	}

	
	@SuppressWarnings("static-access")
	private void insertLOG(String username) throws SQLException{
		
		LOG.info("Gravando LOG na base de dados");
		
		String sql = "INSERT INTO FIAP_SEGURANCA_LOG ( CHAMADA , DATA , HORA , USUARIO ) " +
					 " VALUES ( ? , ? , ? , ?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		Calendar calendar = GregorianCalendar.getInstance();
		
		String hora = String.valueOf(calendar.get(calendar.HOUR_OF_DAY)+":");
		hora = hora.concat(String.valueOf(calendar.get(calendar.MINUTE)+":"));
		hora = hora.concat(String.valueOf(calendar.get(calendar.SECOND)));
		
		String date = String.valueOf(calendar.get(calendar.YEAR)+"-");
		date = date.concat(String.valueOf(calendar.get(calendar.MONTH))+"-");
		date = date.concat(String.valueOf(calendar.get(calendar.DAY_OF_MONTH)));
		
		preparedStatement.setString(1 , " LOGIN ");
		preparedStatement.setString(2 ,date);
		preparedStatement.setString(3 , hora);
		preparedStatement.setString(4 , username);
		
		preparedStatement.execute();
		
		preparedStatement.close();
	}
	
	public LoginModel executeLogin(String username){
		
		try{
			
			openConnection();

			return executeQuery(username);
			
		}catch (Exception e) {
			LOG.error("ERRO ao executar login : " +e.getMessage());
		}finally {
			
			LOG.info("Finalizando Conexao e Contexto ");
			
			try{
				if(connection != null && !connection.isClosed())
					connection.close();
			}catch (Exception e) {
				LOG.error("ERRO ao fechar conexao");
			}
			dataSource = null;

			if(context!=null) {
				try {
					context.close();
				} catch(Exception e) {
					LOG.error("ERRO ao finalizar contexto");
				} 
			}
		}
		
		return null;
	}
	
	/**
	 
	 * @throws NamingException 
	 * @throws SQLException 
	 */
	private void openConnection() throws NamingException, SQLException{

		LOG.info("Fazendo lookup do dataSource");

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");

		context = new InitialContext();
		dataSource = (javax.sql.DataSource)context.lookup(dataSoureJndi);

		LOG.info("Obtendo conexao");
		connection = dataSource.getConnection();

	}
}
