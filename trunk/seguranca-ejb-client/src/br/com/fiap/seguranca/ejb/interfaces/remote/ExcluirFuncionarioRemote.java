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
 *
 */
@Remote
public interface ExcluirFuncionarioRemote {

	/**
	 * Excluir o funcionario informado como parâmetro
	 * @param funcionario {@link Funcionario}
	 * @throws EJBException
	 */
	public void excluirFuncionario(Funcionario funcionario) throws EJBException;
	
	/**
	 * Lista todos os funcionarios
	 * @return {@link List} < {@link Funcionario} >
	 * @throws EJBException
	 */
	public List<Funcionario> listarFuncionarios() throws EJBException;
}
