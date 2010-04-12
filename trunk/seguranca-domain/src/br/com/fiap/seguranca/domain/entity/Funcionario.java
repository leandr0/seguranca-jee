/**
 * 
 */
package br.com.fiap.seguranca.domain.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Email;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

import br.com.fiap.seguranca.domain.enums.PerfilFuncionario;

/**
 * @author leandro.goncalves
 *
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario implements EntityBasic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953295599273905514L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "PERFIL", nullable = false)
	@NotEmpty(message = "O perfil do funcionário deve informado")
	@Enumerated(EnumType.STRING)
	private PerfilFuncionario perfil;
	
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de nascimento deve ser informada")
	private Calendar dataNascimento;
	
	@Column(name = "TELEFONE", nullable = false)
	@NotEmpty(message = "O telefone deve ser informado")
	private String telefone;
	
	@Column(name = "E_MAIL", nullable = false)
	@NotNull(message = "O campo e-mail deve ser preenchido")
	@Email(message = "O campo e-mail deve ser preenchido corretamente")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SEGURANCA_ID" , nullable = false)
	private Seguranca  seguranca;
	
	@Column(name = "NOME", nullable = false)
	@NotNull(message = "O campo nome deve ser preenchido")
	private String nome;
	
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
	 * @return the perfil
	 */
	public PerfilFuncionario getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(PerfilFuncionario perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the dataNascimento
	 */
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the seguranca
	 */
	public Seguranca getSeguranca() {
		return seguranca;
	}

	/**
	 * @param seguranca the seguranca to set
	 */
	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}