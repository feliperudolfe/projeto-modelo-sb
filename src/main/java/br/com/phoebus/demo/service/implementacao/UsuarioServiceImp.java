package br.com.phoebus.demo.service.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phoebus.demo.modelo.entidade.Usuario;
import br.com.phoebus.demo.repositorio.UsuarioRepository;
import br.com.phoebus.demo.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
		return usuarioRepository.buscarUsuarioPorLoginESenha(login, senha);
	}// buscarUsuarioPorLoginESenha()

}