package br.com.feliperudolfe.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.feliperudolfe.comum.modelo.Entidade;

/**
 * @Autor	Felipe Rudolfe Carvalho Pinheiro
 * @Data	18 de set de 2017
 */
@Entity
@Table(name = "tb_funcoes")
public class Funcao extends Entidade<String> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4633790043912451340L;

	@Id
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nome", nullable = false, length = 45)
	private String nome;

	public Funcao() {	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Funcao other = (Funcao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}