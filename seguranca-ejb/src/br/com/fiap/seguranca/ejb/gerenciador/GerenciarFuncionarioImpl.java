/**
 * 
 */
package br.com.fiap.seguranca.ejb.gerenciador;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.exceptions.GerenciadorException;
import br.com.fiap.seguranca.ejb.gerenciador.interfaces.GerenciarFuncionario;

/**
 * @author leandro.goncalves
 * DAO para entidade funcionario
 */
@Stateless(name = "gerenciadorFuncionario")
@Local(GerenciarFuncionario.class)
public class GerenciarFuncionarioImpl extends GerenciarGeneric<Funcionario> implements GerenciarFuncionario {

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcionario> listarFuncionarios() throws GerenciadorException {
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Funcionario.class);
		
		criteria.add(Restrictions.eq("perfil", PerfilFuncionario.FUNCIONARIO))
		.addOrder(Order.asc("nome"));
		
		return criteria.list();
	}

}
