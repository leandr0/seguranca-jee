/**
 * 
 */
package br.com.fiap.seguranca.ejb.gerenciador.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.ejb.exceptions.GerenciadorException;

/**
 * @author leandro.goncalves
 * Interface local para gerenciadorFuncionario
 */
@Local
public interface GerenciarFuncionario extends GerenciadorBasic<Funcionario>{

	
	/**
	 * Método responsável por devolver todos funcionários cadastrados
	 * @return {@link List} < {@link Funcionario} >
	 * @throws GerenciadorException
	 */
	public List<Funcionario> listarFuncionarios() throws GerenciadorException;
}
