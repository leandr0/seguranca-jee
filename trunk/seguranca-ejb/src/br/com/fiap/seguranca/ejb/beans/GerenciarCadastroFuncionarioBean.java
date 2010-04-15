/**
 * 
 */
package br.com.fiap.seguranca.ejb.beans;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.seguranca.domain.entity.EntityBasic;
import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.gerenciador.interfaces.GerenciarFuncionario;
import br.com.fiap.seguranca.ejb.interceptor.FiapSegurancaInterceptor;
import br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal;
import br.com.fiap.seguranca.ejb.interfaces.remote.CadastrarFuncionarioRemote;
import br.com.fiap.seguranca.util.criptografia.CriptografiaUtil;
import br.com.fiap.seguranca.validator.CadastrarFuncionarioValidator;

/**
 * @author leandro.goncalves
 * Classe de negócio responsável por cadastrar funcionários
 */
@Stateful(name = "cadastrarFuncionario")
@Local(CadastrarFuncionarioLocal.class)
@Remote(CadastrarFuncionarioRemote.class)
@SecurityDomain("seguranca-fiap-custom")
@Interceptors(FiapSegurancaInterceptor.class)
public class GerenciarCadastroFuncionarioBean extends BeanValidator implements CadastrarFuncionarioLocal,CadastrarFuncionarioRemote{

	@EJB
	private GerenciarFuncionario gerenciarFuncionario;

	private static final Log LOG = LogFactory.getLog(GerenciarCadastroFuncionarioBean.class);

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal#cadastrarFuncionario(br.com.fiap.seguranca.domain.entity.Funcionario)
	 */
	@Override
	@PermitAll
	public Funcionario cadastrarFuncionario(Funcionario funcionario)throws EJBException {

		try{

			validateEntity(funcionario.getSeguranca());

			if(valid){

				LOG.info("Cadastrando funcionario");
				funcionario.getSeguranca().setSenha(
						CriptografiaUtil.criptografar(funcionario.getSeguranca().getSenha()));
				funcionario = gerenciarFuncionario.insert(funcionario);
				
				valid = true;
				
				return funcionario; 

			}else{

				LOG.info("Dados invalidos");
				return funcionario;
			}
		}catch (EJBTransactionRolledbackException e) {
			/**
			 * Tratamento para duplicidade de login na base de dados
			 */
			if(e.getCausedByException().getCause().getClass().equals(ConstraintViolationException.class)){
				messageValidator = "Login já está sendo utilizado por outro usuário.";
				valid = false;
				return funcionario;
			}
			else	
				throw new EJBException(e);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EJBException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal#validarFuncionario(br.com.fiap.seguranca.domain.entity.Funcionario)
	 */
	@Override
	@PermitAll
	public boolean validarFuncionario(Funcionario funcionario) throws EJBException {

		funcionario.setPerfil(PerfilFuncionario.FUNCIONARIO);

		validateEntity(funcionario);

		if(messageValidator != null)
			valid = false;
		else
			valid = true;

		return valid;
	}

	/**
	 * Valida as entidades de utilizadas nas regras de negocio
	 * @param entity {@link EntityBasic}
	 */
	private <E extends EntityBasic> void validateEntity(E entity){

		LOG.info("Iniciando validacao de dados da entidade : "+entity.getClass().getSimpleName());
		validator = new CadastrarFuncionarioValidator();

		LOG.info("Validando dados da entidades : "+entity.getClass().getSimpleName());
		messageValidator = validator.validar(entity);

		if(messageValidator != null)
			valid = false;
		else
			valid = true;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal#listarFuncionarios()
	 */
	@Override
	@PermitAll
	public List<Funcionario> listarFuncionarios() throws EJBException {
		LOG.info("Listando funcionarios");
		return gerenciarFuncionario.listarFuncionarios();
	}
}
