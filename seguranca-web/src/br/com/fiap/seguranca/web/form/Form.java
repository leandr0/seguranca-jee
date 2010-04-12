/**
 * 
 */
package br.com.fiap.seguranca.web.form;

/**
 * @author leandro.goncalves
 * Classe que contem variaveis para controle ou 
 * exibicao no formulario que nao sejam entidades 
 */
public abstract class Form {

	/**
	 * Mensagens de validacao
	 */
	protected String mensagem;

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
