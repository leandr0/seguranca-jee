/**
 * 
 */
package br.com.fiap.seguranca.web.model;

import br.com.fiap.seguranca.domain.entity.Funcionario;
import br.com.fiap.seguranca.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 * Classe que contem as entidades para as 
 * acoes do manager bean
 */
public class CadastrarFuncionarioModel {

	private Funcionario funcionario;

	/**
	 * 
	 */
	public CadastrarFuncionarioModel() {
		funcionario = new Funcionario(new Seguranca());
	}
	
	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
