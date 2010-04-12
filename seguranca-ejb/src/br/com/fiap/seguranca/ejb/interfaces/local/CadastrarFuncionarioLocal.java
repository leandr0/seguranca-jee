/**
 * 
 */
package br.com.fiap.seguranca.ejb.interfaces.local;

import javax.ejb.EJBException;
import javax.ejb.Local;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * @author leandro.goncalves
 * Interface local para cadastrar funcionario
 */
@Local
public interface CadastrarFuncionarioLocal extends LocalValidator{

	/**
	 * Cadastro de funcionario
	 * @param funcionario {@link Funcionario}
	 * @return {@link Funcionario}
	 * @throws EJBException
	 */
	public Funcionario cadastrarFuncionario(Funcionario funcionario)throws EJBException;
	
}
