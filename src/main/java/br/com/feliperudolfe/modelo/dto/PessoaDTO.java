package br.com.feliperudolfe.modelo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.feliperudolfe.comum.modelo.DTO;
import br.com.feliperudolfe.modelo.entidade.Pessoa;
import br.com.feliperudolfe.modelo.tipo.Generos;

public class PessoaDTO extends DTO<Pessoa> {

	/**
	 *
	 */
	private static final long serialVersionUID = 3204509361364748185L;

	private Long codigo;

	@NotNull(message = "'Nome completo' é obrigatório")
	@NotBlank(message = "'Nome completo' é obrigatório")
	@Size(min = 6, max = 45, message = "'Nome completo' deve conter entre '{min}' e '{max}' caracteres")
	private String nomeCompleto;

	@NotNull(message = "'Gênero' é obrigatório")
	private Generos genero;

	@NotNull(message = "'Data de nascimento' é obrigatória")
	private Date dataNascimento;

	private Date registro;

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

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

}