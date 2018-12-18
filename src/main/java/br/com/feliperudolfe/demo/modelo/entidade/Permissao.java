package br.com.feliperudolfe.demo.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import br.com.feliperudolfe.comum.modelo.Entidade;

@Entity
@Table(name = "tb_permissoes")
public class Permissao extends Entidade<String> implements GrantedAuthority {

	/**
	 *
	 */
	private static final long serialVersionUID = 7921654342984928530L;

	@Id
	@Column(unique = true, nullable = false)
	private String codigo;

	@Column(unique = true, nullable = false)
	private String titulo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String getAuthority() {
		return "ROLE_" + this.codigo;
	}

}