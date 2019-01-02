package br.com.feliperudolfe.service;

import java.util.List;

import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.modelo.entidade.Projeto;

public interface ProjetoService {

	List<Projeto> listar() throws NegocioException;

}