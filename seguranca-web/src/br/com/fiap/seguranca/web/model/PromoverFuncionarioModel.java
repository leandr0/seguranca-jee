/**
 * 
 */
package br.com.fiap.seguranca.web.model;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * @author leandro.goncalves
 * Classe que contem as entidades para as 
 * acoes do manager bean
 */
public class PromoverFuncionarioModel {

	private Funcionario funcionario;

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