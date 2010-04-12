/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.ejb.dao.interfaces.FuncionarioDAO;

/**
 * @author leandro.goncalves
 * DAO para entidade funcionario
 */
@Stateless(name = "funcionarioDAO")
@Local(FuncionarioDAO.class)
public class FuncionarioDAOImpl extends GenericDAO<Funcionario> implements FuncionarioDAO {

}
