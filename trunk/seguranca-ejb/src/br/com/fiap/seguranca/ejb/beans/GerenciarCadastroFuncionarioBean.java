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
	
	@Override
	@PermitAll
	public Funcionario cadastrarFuncionario(Funcionario funcionario)throws EJBException {
		
		validator = new CadastrarFuncionarioValidator();

		funcionario.setPerfil(PerfilFuncionario.FUNCIONARIO);
		
		messageValidator = validator.validar(funcionario);
		
		if(messageValidator != null)
			valid = false;
		else
			valid = true;
		
		return funcionarioDAO.insert(funcionario);

	}
}
