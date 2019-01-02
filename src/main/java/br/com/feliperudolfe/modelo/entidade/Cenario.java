package br.com.feliperudolfe.modelo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.feliperudolfe.comum.modelo.Entidade;
import br.com.feliperudolfe.modelo.tipo.Criticidades;
import br.com.feliperudolfe.modelo.tipo.Relevancias;

/**
 * @Autor 		Felipe Rudolfe Carvalho Pinheiro
 * @Data		23 de dez de 2018 às 09:59:40
 */
@Entity
@Table(name = "tb_cenarios")
public class Cenario extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -8768776831669726413L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable = false)
	private String tc;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Relevancias relevance;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private Criticidades criticity;

	@OneToMany(mappedBy = "cenario")
	private List<Entrada> entradas;

	@ManyToOne
	@JoinColumn(name = "suite")
	private Suite suite;

	@ManyToOne
	@JoinColumn(name = "projeto")
	private Projeto projeto;

	private transient String preCondicoes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Relevancias getRelevance() {
		return relevance;
	}

	public void setRelevance(Relevancias relevance) {
		this.relevance = relevance;
	}

	public Criticidades getCriticity() {
		return criticity;
	}

	public void setCriticity(Criticidades criticity) {
		this.criticity = criticity;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
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

	public String getPreCondicoes() {
		return preCondicoes;
	}

	public void setPreCondicoes(String preCondicoes) {
		this.preCondicoes = preCondicoes;
	}

}