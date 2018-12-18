package br.com.feliperudolfe.demo.service;

import br.com.feliperudolfe.demo.modelo.entidade.Usuario;

public interface UsuarioService {

	Usuario buscarUsuarioPorLoginESenha(String login, String senha);

}