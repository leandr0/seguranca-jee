/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao.interfaces;

import javax.ejb.Local;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * @author leandro.goncalves
 * Interface local para funcionarioDAO
 */
@Local
public interface FuncionarioDAO extends BasicDAO<Funcionario>{

}
