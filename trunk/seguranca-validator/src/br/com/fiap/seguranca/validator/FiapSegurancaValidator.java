/**
 * 
 */
package br.com.fiap.seguranca.validator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import br.com.fiap.seguranca.domain.entity.EntityBasic;

/**
 * @author leandro.goncalves
 * Classe para validacao das entidades com uma implementacao padrao
 */
public abstract class FiapSegurancaValidator {

	/**
	 * Método de validação das entidades
	 * @param entity {@link EntityBasic}
	 * @return {@link String}
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBasic> String validar(T entity){
		
		ClassValidator<T> validator = new ClassValidator<T>((Class<T>) entity.getClass());
		for(InvalidValue values : validator.getInvalidValues((T) entity)){
			return values.getMessage();
		}
		
		return null;
	}
}
