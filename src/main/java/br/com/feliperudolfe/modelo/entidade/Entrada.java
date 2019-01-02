package br.com.feliperudolfe.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.feliperudolfe.comum.modelo.Entidade;

@Entity
@Table(name = "tb_entradas")
public class Entrada extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -908703945757283624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable = false)
	private String cabecalho;

	@Column(nullable = false)
	private String linha;

	@ManyToOne
	@JoinColumn(name = "cenario")
	private Cenario cenario;

	@ManyToOne
	@JoinColumn(name = "suite")
	private Suite suite;

	@ManyToOne
	@JoinColumn(name = "projeto")
	private Projeto projeto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public Cenario getCenario() {
		return cenario;
	}

	public void setCenario(Cenario cenario) {
		this.cenario = cenario;
	}

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}