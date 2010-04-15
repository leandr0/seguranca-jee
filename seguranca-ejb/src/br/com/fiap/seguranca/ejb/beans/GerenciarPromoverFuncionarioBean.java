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
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;
import br.com.fiap.seguranca.ejb.gerenciador.interfaces.GerenciarFuncionario;
import br.com.fiap.seguranca.ejb.interceptor.FiapSegurancaInterceptor;
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
@Interceptors(FiapSegurancaInterceptor.class)
public class GerenciarPromoverFuncionarioBean implements PromoverFuncionarioLocal, PromoverFuncionarioRemote{

	@EJB
	private GerenciarFuncionario gerenciarFuncionario;
	
	private static final Log LOG = LogFactory.getLog(GerenciarPromoverFuncionarioBean.class);
	
	@Override
	@RolesAllowed("GERENTE")
	public Funcionario promoverFucionarioGerente(Funcionario funcionario)throws EJBException {

		LOG.info("Adicionando perfil de gerente para funcinario");
		
		funcionario.setPerfil(PerfilFuncionario.GERENTE);
		
		LOG.info("Atualizando registro do funcionario");
		gerenciarFuncionario.update(funcionario);
		
		return funcionario;
	}

	@Override
	@RolesAllowed("GERENTE")
	public List<Funcionario> listarFuncionarios() throws EJBException {
		LOG.info("Listando funcionarios");
		return gerenciarFuncionario.listarFuncionarios();
	}	
}