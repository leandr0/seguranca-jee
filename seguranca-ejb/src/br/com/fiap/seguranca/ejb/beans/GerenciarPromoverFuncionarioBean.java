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
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.dao.interfaces.FuncionarioDAO;
import br.com.fiap.seguranca.ejb.interfaces.local.PromoverFuncionarioLocal;
import br.com.fiap.seguranca.ejb.interfaces.remote.PromoverFuncionarioRemote;

/**
 * @author leandro.goncalves
 * Classe de negócio para promover funcionario
 */
@Stateless(name = "promoverFuncionario")
@Local(PromoverFuncionarioLocal.class)
@Remote(PromoverFuncionarioRemote.class)
@SecurityDomain("seguranca-fiap-custom")
public class GerenciarPromoverFuncionarioBean implements PromoverFuncionarioLocal, PromoverFuncionarioRemote{

	@EJB
	private FuncionarioDAO funcionarioDAO;
	
	private static final Log LOG = LogFactory.getLog(GerenciarPromoverFuncionarioBean.class);
	
	@Override
	@RolesAllowed("GERENTE")
	public Funcionario promoverFucionarioGerente(Funcionario funcionario)throws EJBException {

		LOG.info("Adicionando perfil de gerente para funcinario");
		
		funcionario.setPerfil(PerfilFuncionario.GERENTE);
		
		LOG.info("Atualizando registro do funcionario");
		funcionarioDAO.update(funcionario);
		
		return funcionario;
	}

	@Override
	@RolesAllowed("GERENTE")
	public List<Funcionario> listarFuncionarios() throws EJBException {
		LOG.info("Listando funcionarios");
		return funcionarioDAO.listarFuncionarios();
	}	
}