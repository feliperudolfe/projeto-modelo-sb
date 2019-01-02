package br.com.feliperudolfe.modelo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.feliperudolfe.comum.modelo.Entidade;

/**
 * @Autor 		Felipe Rudolfe Carvalho Pinheiro
 * @Data		23 de dez de 2018 às 09:57:11
 */
@Entity
@Table(name = "tb_suites")
public class Suite extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4991119745985678665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(nullable = false, length = 128)
	private String uc;

	@Column(nullable = false, length = 255)
	private String titulo;

	@OneToMany(mappedBy = "suite")
	private List<Cenario> cenarios;

	@ManyToOne
	@JoinColumn(name = "projeto")
	private Projeto projeto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUc() {
		return uc;
	}

	public void setUc(String uc) {
		this.uc = uc;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Cenario> getCenarios() {
		return cenarios;
	}

	public void setCenarios(List<Cenario> cenarios) {
		this.cenarios = cenarios;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}