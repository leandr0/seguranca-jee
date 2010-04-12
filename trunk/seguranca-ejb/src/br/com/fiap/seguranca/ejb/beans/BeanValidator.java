/**
 * 
 */
package br.com.fiap.seguranca.ejb.beans;

import br.com.fiap.seguranca.validator.FiapSegurancaValidator;

/**
 * @author leandro.goncalves
 * Classe para serem estendidas pelos beans que necessitam validar as entidades
 */
public abstract class BeanValidator {

	/**
	 * Atributo que irá receber em tempo de execucao
	 * a implementacao do validador da classe de negocio
	 */
	protected FiapSegurancaValidator validator;
	
	/**
	 * Mensagem retornada pela validacao
	 */
	protected String messageValidator;
	
	/**
	 * Indica se a validacao foi efetuada com sucesso
	 */
	protected boolean valid;

	/**
	 * @return the messageValidator
	 */
	public String getMessageValidator() {
		return messageValidator;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
}