package br.com.feliperudolfe.service;

import java.util.List;

import br.com.feliperudolfe.modelo.entidade.Pessoa;

public interface PessoaService {

	List<Pessoa> listar();

	void cadastrar(Pessoa pessoa);

	Pessoa buscarPorId(Long codigo);

	void editar(Pessoa pessoa);

	void remover(Long codigo);
	
}