/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.ejb.exceptions.DAOException;

/**
 * @author leandro.goncalves
 * Interface local para funcionarioDAO
 */
@Local
public interface FuncionarioDAO extends BasicDAO<Funcionario>{

	
	/**
	 * M�todo respons�vel por devolver todos funcion�rios cadastrados
	 * @return {@link List} < {@link Funcionario} >
	 * @throws DAOException
	 */
	public List<Funcionario> listarFuncionarios() throws DAOException;
}
