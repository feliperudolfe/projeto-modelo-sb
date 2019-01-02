package br.com.feliperudolfe.modelo.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.feliperudolfe.comum.modelo.Entidade;

/**
 * @Autor 	Felipe Rudolfe Carvalho Pinheiro
 * @Data 	18 de set de 2017
 */
@Entity
@Table(name = "tb_projetos")
public class Projeto extends Entidade<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 2777892533099736531L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "nome", nullable = false, length = 45)
	private String nome;

	@Column(name = "token", nullable = false)
	private String token;

	@Column(name = "imagem")
	private String imagem;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inicio", nullable = false)
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	private transient List<Colaborador> colaboradores;

	@OneToOne
	@JoinColumn(name = "proprietario")
	private Usuario proprietario;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

}