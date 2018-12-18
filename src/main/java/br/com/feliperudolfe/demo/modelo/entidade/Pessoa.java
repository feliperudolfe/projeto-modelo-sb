package br.com.feliperudolfe.demo.modelo.entidade;

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
import br.com.feliperudolfe.demo.modelo.tipo.Generos;

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
	private Long codigo;

	@Column(nullable = false, length = 60)
	private String nome;

	@Enumerated(EnumType.STRING)
	private Generos genero;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}