package br.com.feliperudolfe.demo.service.implementacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.feliperudolfe.demo.modelo.entidade.Usuario;
import br.com.feliperudolfe.demo.repositorio.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.buscarUsuarioPorLogin(login);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}// if
		return usuario;
	}// loadUserByUsername()

}