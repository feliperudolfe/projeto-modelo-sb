package br.com.phoebus.demo.service;

import java.util.List;

import br.com.phoebus.demo.modelo.entidade.Pessoa;

public interface PessoaService {

	List<Pessoa> listar();

	void cadastrar(Pessoa pessoa);

	Pessoa buscarPorId(Long codigo);

	void editar(Pessoa pessoa);

	void remover(Long codigo);
	
}