package br.com.fiap.seguranca.web.form;

import java.util.List;

import br.com.fiap.seguranca.domain.entity.Funcionario;

/**
 * 
 * @author leandro.goncalves
 * Classe que contem variaveis para controle ou 
 * exibicao no formulario que nao sejam entidades 
 */
public class ExcluirFuncionarioForm extends Form{

	private List<Funcionario> funcionarios;

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
}