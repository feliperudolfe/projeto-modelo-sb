package br.com.feliperudolfe.app.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.feliperudolfe.demo.modelo.entidade.Usuario;
import br.com.feliperudolfe.demo.service.UsuarioService;

@Component
public class AuthProviderService implements AuthenticationProvider {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login = auth.getName();
		String senha = auth.getCredentials().toString();

		Usuario usuario = this.usuarioService.buscarUsuarioPorLoginESenha(login, senha);
		if (usuario != null) {
			if (usuario.isEnabled()) {
				return new UsernamePasswordAuthenticationToken(login, senha, usuario.getAuthorities());
			} else {
				throw new BadCredentialsException("Este usuário está desativado.");
			}// if-else
		}// if

		throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
	}// authenticate()

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}// supports()

}