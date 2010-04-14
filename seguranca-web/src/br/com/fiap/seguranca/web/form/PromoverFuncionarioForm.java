/**
 * 
 */
package br.com.fiap.seguranca.web.form;

import java.util.List;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * @author leandro.goncalves
 *Classe que contem variaveis para controle ou 
 * exibicao no formulario que nao sejam entidades 
 */
public class PromoverFuncionarioForm extends Form{

	private List<Funcionario> funcionarios;

	private Long idFuncionario;
	
	/**
	 * @return the funcionarios
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the idFuncionario
	 */
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}