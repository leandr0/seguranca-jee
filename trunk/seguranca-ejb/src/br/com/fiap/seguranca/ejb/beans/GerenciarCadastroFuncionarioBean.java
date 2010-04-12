/**
 * 
 */
package br.com.fiap.seguranca.ejb.beans;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.dao.interfaces.FuncionarioDAO;
import br.com.fiap.seguranca.ejb.interfaces.local.CadastrarFuncionarioLocal;
import br.com.fiap.seguranca.ejb.interfaces.remote.CadastrarFuncionarioRemote;
import br.com.fiap.seguranca.validator.CadastrarFuncionarioValidator;

/**
 * @author leandro.goncalves
 * Classe de negócio responsável por cadastrar funcionários
 */
@Stateful(name = "cadastrarFuncionario")
@Local(CadastrarFuncionarioLocal.class)
@Remote(CadastrarFuncionarioRemote.class)
@SecurityDomain("seguranca-fiap-custom")
public class GerenciarCadastroFuncionarioBean extends BeanValidator implements CadastrarFuncionarioLocal,CadastrarFuncionarioRemote{

	@EJB
	private FuncionarioDAO funcionarioDAO;
	
	private static final Log LOG = LogFactory.getLog(GerenciarCadastroFuncionarioBean.class);
	
	@Override
	@PermitAll
	public Funcionario cadastrarFuncionario(Funcionario funcionario)throws EJBException {
		
		LOG.info("Iniciando cadastro de funcionario");
		
		validator = new CadastrarFuncionarioValidator();

		funcionario.setPerfil(PerfilFuncionario.FUNCIONARIO);

		LOG.info("Validando dados do funcionario");
		messageValidator = validator.validar(funcionario);
		
		if(messageValidator != null)
			valid = false;
		else
			valid = true;
		
		LOG.info("Cadastrando funcionario");
		return funcionarioDAO.insert(funcionario);

	}
}
