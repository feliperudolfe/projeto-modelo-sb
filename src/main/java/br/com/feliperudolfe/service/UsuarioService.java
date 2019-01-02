package br.com.feliperudolfe.service;

import br.com.feliperudolfe.comum.tratamento.NegocioException;
import br.com.feliperudolfe.modelo.entidade.Usuario;

public interface UsuarioService {

	Usuario buscarUsuarioPorEmail(String login);

	Usuario buscarUsuarioPorEmailESenha(String login, String senha);

	Usuario getUsuarioLogado();

	Boolean isUsuarioLogado();

	void cadastrar(Usuario usuario) throws NegocioException;

}