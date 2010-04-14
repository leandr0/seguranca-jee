/**
 * 
 */
package br.com.fiap.seguranca.ejb.interfaces.remote;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Remote;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * @author leandro.goncalves
 * Interface Remota para cadastrar funcionario
 */
@Remote
public interface CadastrarFuncionarioRemote extends RemoteValidator{
	
	/**
	 * Cadastro de funcionario
	 * @param funcionario {@link Funcionario}
	 * @return {@link Funcionario}
	 * @throws EJBException
	 */
	public Funcionario cadastrarFuncionario(Funcionario funcionario)throws EJBException;
	
	
	/**
	 * Valida os dados informados para o cadastro de funcionario
	 * @param funcionario {@link Funcionario}
	 * @return {@link Boolean}
	 * @throws EJBException
	 */
	public boolean validarFuncionario(Funcionario funcionario)throws EJBException;
	
	/**
	 * Lista todos os funcionarios
	 * @return {@link List} < {@link Funcionario} >
	 * @throws EJBException
	 */
	public List<Funcionario> listarFuncionarios() throws EJBException;
}
