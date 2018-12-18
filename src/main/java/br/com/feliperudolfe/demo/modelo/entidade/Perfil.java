package br.com.feliperudolfe.demo.modelo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.feliperudolfe.comum.modelo.Entidade;

@Entity
@Table(name = "tb_perfis")
public class Perfil extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -3399575113635556705L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(unique = true, nullable = false)
	private String titulo;

	@ManyToMany
	@JoinTable(name = "tb_permissoes_perfil", joinColumns = @JoinColumn(name = "perfil"), inverseJoinColumns = @JoinColumn(name = "permissao"))
	private List<Permissao> permissoes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}