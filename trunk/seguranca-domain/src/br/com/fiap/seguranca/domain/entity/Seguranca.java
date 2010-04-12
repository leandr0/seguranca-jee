/**
 * 
 */
package br.com.fiap.seguranca.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;

/**
 * @author leandro.goncalves
 *
 */
@Entity
@Table(name = "SEGURANCA")
public class Seguranca implements EntityBasic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8318862327378290939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LOGIN" , nullable = false , unique = true)
	@NotEmpty(message = "O Login deve ser preenchido")
	private String login;
	
	@Column(name = "SENHA" , nullable = false)
	@NotEmpty(message = "A Sehna deve ser preenchida")
	private String senha;
	
	@OneToOne(mappedBy = "seguranca")
	private Funcionario funcionario;
	
	/* (non-Javadoc)
	 * @see br.com.fiap.seguranca.domain.entity.EntityBasic#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see br.com.fiap.seguranca.domain.entity.EntityBasic#setId(java.lang.Long)
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
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