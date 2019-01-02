package br.com.feliperudolfe.modelo.chave;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.feliperudolfe.modelo.entidade.Cenario;
import br.com.feliperudolfe.modelo.entidade.Entrada;
import br.com.feliperudolfe.modelo.entidade.Projeto;
import br.com.feliperudolfe.modelo.entidade.Suite;

@Embeddable
public class PK_Resultado implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 5548706703398238242L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long resultado;

	@ManyToOne
	@JoinColumn(name = "entrada")
	private Entrada entrada;

	@ManyToOne
	@JoinColumn(name = "cenario")
	private Cenario cenario;

	@ManyToOne
	@JoinColumn(name = "suite")
	private Suite suite;

	@ManyToOne
	@JoinColumn(name = "projeto")
	private Projeto projeto;

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Cenario getCenario() {
		return cenario;
	}

	public void setCenario(Cenario cenario) {
		this.cenario = cenario;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}