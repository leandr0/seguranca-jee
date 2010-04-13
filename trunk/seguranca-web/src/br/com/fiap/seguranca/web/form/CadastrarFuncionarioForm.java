/**
 * 
 */
package br.com.fiap.seguranca.web.form;

import java.util.Date;

/**
 * @author leandro.goncalves
 * Classe que contem variaveis para controle ou 
 * exibicao no formulario que nao sejam entidades 
 */
public class CadastrarFuncionarioForm extends Form{

	private Date dataNascimento;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}