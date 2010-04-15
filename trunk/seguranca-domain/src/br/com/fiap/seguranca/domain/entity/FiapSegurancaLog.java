/**
 * 
 */
package br.com.fiap.seguranca.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author leandro.goncalves
 *
 */
@Entity
@Table(name = "FIAP_SEGURANCA_LOG")
public class FiapSegurancaLog implements EntityBasic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5146699934108571684L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "USUARIO", nullable = false)
	private String usuario;
	
	@Column(name = "DATA", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "HORA" , nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora; 
	
	@Column(name = "CHAMADA")
	private String chamada;
	
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the hora
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}

	/**
	 * @return the chamada
	 */
	public String getChamada() {
		return chamada;
	}

	/**
	 * @param chamada the chamada to set
	 */
	public void setChamada(String chamada) {
		this.chamada = chamada;
	}
}