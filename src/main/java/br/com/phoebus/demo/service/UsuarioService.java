package br.com.phoebus.demo.service;

import br.com.phoebus.demo.modelo.entidade.Usuario;

public interface UsuarioService {

	Usuario buscarUsuarioPorLoginESenha(String login, String senha);

}