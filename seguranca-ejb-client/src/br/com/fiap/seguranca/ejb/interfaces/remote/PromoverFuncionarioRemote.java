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
 * Interface Remota para promover funcionario
 */
@Remote
public interface PromoverFuncionarioRemote {

	/**
	 * M�todo repons�vel pela promo��o de um funcion�rio para gerente
	 * @param funcionario {@link Funcionario}
	 * @return {@link Funcionario}
	 * @throws EJBException
	 */
	public Funcionario promoverFucionarioGerente(Funcionario funcionario) throws EJBException;
	
	/**
	 * M�todo respons�vel por devolver todos funcion�rios cadastrados
	 * @return {@link List} < {@link Funcionario} >
	 * @throws EJBException
	 */
	public List<Funcionario> listarFuncionarios() throws EJBException;
}
