package br.com.phoebus.comum.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 	felipe.rudolfe
 * @date	3 de dez de 2018 às 16:32:26
 */
@MappedSuperclass
public abstract class Entidade<T> implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Temporal(TemporalType.TIMESTAMP)
	private Date atualizacao;

	public abstract T getCodigo();

	public abstract void setCodigo(T codigo);

	public Date getRegistro() {
		return registro;
	}

	public Date getAtualizacao() {
		return atualizacao;
	}

	@PrePersist
	public void prePersist() {
		this.registro = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.atualizacao = new Date();
	}

}