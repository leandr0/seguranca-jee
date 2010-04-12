/**
 * 
 */
package br.com.fiap.seguranca.ejb.beans;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.fiap.seguranca.ejb.interfaces.local.PromoverFuncionarioLocal;
import br.com.fiap.seguranca.ejb.interfaces.remote.PromoverFuncionarioRemote;

/**
 * @author leandro.goncalves
 * Classe de negócio para promover funcionario
 */
@Stateless(name = "promoverFuncionario")
@Local(PromoverFuncionarioLocal.class)
@Remote(PromoverFuncionarioRemote.class)
public class GerenciarPromoverFuncionarioBean implements PromoverFuncionarioLocal, PromoverFuncionarioRemote{

}
