package br.com.feliperudolfe.modelo.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.feliperudolfe.comum.modelo.Entidade;
import br.com.feliperudolfe.modelo.tipo.Generos;

/**
 * @author 	felipe.rudolfe
 * @date	3 de dez de 2018 às 16:35:02
 */
@Entity
@Table(name = "tb_pessoas")
public class Pessoa extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 884044114242852460L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "nome_completo", nullable = false, length = 45)
	private String nomeCompleto;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "genero", length = 1)
	private Generos genero;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

}