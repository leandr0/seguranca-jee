/**
 * 
 */
package br.com.fiap.seguranca.ejb.beans;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.ejb.dao.interfaces.FuncionarioDAO;
import br.com.fiap.seguranca.ejb.interfaces.local.ExcluirFuncionarioLocal;
import br.com.fiap.seguranca.ejb.interfaces.remote.ExcluirFuncionarioRemote;

/**
 * @author leandro.goncalves
 * Classe de negocio para exclusao de funcionarios
 */
@Stateless(name = "excluirFuncionario")
@Local(ExcluirFuncionarioLocal.class)
@Remote(ExcluirFuncionarioRemote.class)
@SecurityDomain("seguranca-fiap-custom")
public class GerenciarExcluirFuncionarioBean implements ExcluirFuncionarioLocal, ExcluirFuncionarioRemote {

	@EJB
	private FuncionarioDAO funcionarioDAO;

	private static final Log LOG = LogFactory.getLog(GerenciarExcluirFuncionarioBean.class);
	
	/* (non-Javadoc)
	 * @see br.com.fiap.seguranca.ejb.interfaces.local.ExcluirFuncionarioLocal#excluirFuncionario(br.com.fiap.seguranca.domain.entity.Funcionario)
	 */
	@Override
	@RolesAllowed("ADMINISTRADOR")
	public void excluirFuncionario(Funcionario funcionario) throws EJBException {
		
		LOG.info("Excluindo funcionario [ " +funcionario.getNome()+" ]");
		
		funcionario = funcionarioDAO.find(funcionario);
		
		funcionarioDAO.delete(funcionario);

	}

	/* (non-Javadoc)
	 * @see br.com.fiap.seguranca.ejb.interfaces.local.ExcluirFuncionarioLocal#listarFuncionarios(br.com.fiap.seguranca.domain.entity.Funcionario)
	 */
	@Override
	@RolesAllowed("ADMINISTRADOR")
	public List<Funcionario> listarFuncionarios() throws EJBException {
		LOG.info("Listando funcionarios");
		return funcionarioDAO.listarFuncionarios();
	}

}
