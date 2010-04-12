/**
 * 
 */
package br.com.fiap.seguranca.ejb.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.dao.interfaces.FuncionarioDAO;
import br.com.fiap.seguranca.ejb.exceptions.DAOException;

/**
 * @author leandro.goncalves
 * DAO para entidade funcionario
 */
@Stateless(name = "funcionarioDAO")
@Local(FuncionarioDAO.class)
public class FuncionarioDAOImpl extends GenericDAO<Funcionario> implements FuncionarioDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listarFuncionarios() throws DAOException {
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Funcionario.class);
		
		criteria.add(Restrictions.eq("perfil", PerfilFuncionario.FUNCIONARIO))
		.addOrder(Order.asc("nome"));
		
		return criteria.list();
	}

}
