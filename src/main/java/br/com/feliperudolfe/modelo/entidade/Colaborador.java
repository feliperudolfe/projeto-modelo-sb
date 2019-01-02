package br.com.feliperudolfe.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.feliperudolfe.comum.modelo.Entidade;
import br.com.feliperudolfe.modelo.chave.PK_Colaborador;

/**
 * @Autor Felipe Rudolfe Carvalho Pinheiro
 * @Data 18 de set de 2017
 */
@Entity
@Table(name = "tb_colaboradores")
public class Colaborador extends Entidade<PK_Colaborador> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4633790043912451340L;

	@EmbeddedId
	private PK_Colaborador codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora")
	private Date dataHora;

	public PK_Colaborador getCodigo() {
		return codigo;
	}

	public void setCodigo(PK_Colaborador codigo) {
		this.codigo = codigo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}